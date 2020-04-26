package main

import (
	"encoding/json"
	"io/ioutil"
	"net/http"
)

func handle(w http.ResponseWriter, req *http.Request) {
	defer req.Body.Close()
	requestBytes, _ := ioutil.ReadAll(req.Body)

	var jsonMap map[string]json.RawMessage
	_ = json.Unmarshal(requestBytes, &jsonMap)

	response := make([]byte, len(requestBytes))
	response = append(response, requestBytes...)

	w.WriteHeader(200)

	_, _ = w.Write(response)
}

func main() {
	http.HandleFunc("/bench", handle)

	_ = http.ListenAndServe(":8000", nil)
}
