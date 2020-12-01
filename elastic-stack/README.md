-> Các bước setup:
1. Run kafka và tạo topic là elk (xem hướng dẫn trong thư mục kafka-broker)
2. Cần thêm các dependency sau vào file pom.xml
    <dependency>
        <groupId>com.github.danielwegener</groupId>
        <artifactId>logback-kafka-appender</artifactId>
        <version>0.2.0-RC2</version>
    </dependency>
    <dependency>
        <groupId>net.logstash.logback</groupId>
        <artifactId>logstash-logback-encoder</artifactId>
        <version>5.1</version>
    </dependency>
3. Cần thêm file logback-spring.xml với nội dung sau vào resources
    <?xml version="1.0" encoding="UTF-8"?>
    <configuration>
        <springProperty scope="context" name="kakfaHost" source="logging.kafka.host" defaultValue="localhost"/>
        <include resource="org/springframework/boot/logging/logback/base.xml"/>
    
        <appender name="KAFKA" class="com.github.danielwegener.logback.kafka.KafkaAppender">
            <encoder>
                <pattern>
                    %d{yyyy-MM-dd HH:mm:ss SSS} [%thread] %-5level %logger{50} - %msg%n
                </pattern>
            </encoder>
            <topic>elk</topic>
            <appender-ref ref="CONSOLE"/>
            <producerConfig>bootstrap.servers=localhost:9092</producerConfig>
            <keyingStrategy class="com.github.danielwegener.logback.kafka.keying.NoKeyKeyingStrategy"/>
            <deliveryStrategy class="com.github.danielwegener.logback.kafka.delivery.AsynchronousDeliveryStrategy"/>
        </appender>
    
        <root level="INFO">
            <appender-ref ref="KAFKA"/>
            <appender-ref ref="CONSOLE"/>
        </root>
    </configuration>
 4. Cài đặt elastic search
 5. Cài đặt logstash
 6. Cài đặt kibana
                