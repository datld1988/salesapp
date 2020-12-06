-> SETUP:
1. Setup thủ công:
    1.1. Run on the windows:
    set KAFKA_BOOTSTRAP_SERVERS=localhost:9092
    java -jar zipkin-server-2.10.1-exec.jar
    
    1.2. Run on the mac/linux:
    export KAFKA_BOOTSTRAP_SERVERS=localhost:9092
    java -jar zipkin-server-2.10.1-exec.jar
 
------------------------------------------------------------------------------------------------------------------------                
2. Setup bằng docker:    
    2.1. run kafka
    
    2.2. run zipkin
    
    2.3. run các microservice

