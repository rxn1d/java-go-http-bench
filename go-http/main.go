package main

import (
	"io/ioutil"
	"net/http"
)

func handle(w http.ResponseWriter, req *http.Request) {
	query := req.URL.RawQuery

	defer req.Body.Close()
	requestBytes, _ := ioutil.ReadAll(req.Body)

	response := make([]byte, len(query)+len(requestBytes))
	response = append(response, query...)
	response = append(response, requestBytes...)

	w.WriteHeader(200)

	_, _ = w.Write(response)
}

func main() {
	http.HandleFunc("/bench", handle)

	_ = http.ListenAndServe(":8000", nil)
}
