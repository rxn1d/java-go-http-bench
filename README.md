# java-go-http-bench
## Java
To build and run:  
`mvn clean package && java -jar --enable-preview target/java-http-1.0-SNAPSHOT.jar`  
To run attack:  
`vegeta attack -targets test_data.csv -duration 10s -format http -rate 5000/s | vegeta report`