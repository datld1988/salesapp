FROM java:8
EXPOSE 8082
ADD ./target/process-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

