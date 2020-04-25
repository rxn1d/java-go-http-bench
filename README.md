# java-go-http-bench
## Java
To compile and build:  
`mvn clean package && java -jar --enable-preview target/java-http-1.0-SNAPSHOT.jar`  
To run attack:  
`vegeta attack -targets test_data.csv -duration 10s -format http -rate 5000/s | vegeta report`