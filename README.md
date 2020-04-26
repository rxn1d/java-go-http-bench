# java-go-http-bench
## Java
To build and run `Java`:  
`mvn package && java -jar --enable-preview target/java-http-1.0-SNAPSHOT.jar`    

To build and run `Go`:
`go build -o ./go-http/gohttp ./go-http/ && ./go-http/gohttp`

To run attack:  
`vegeta attack -targets test_data.csv -duration 10s -format http -rate 5000/s | vegeta report`

Links:
* https://hdrhistogram.github.io/HdrHistogram/plotFiles.html
* https://github.com/golang/go/wiki/SliceTricks