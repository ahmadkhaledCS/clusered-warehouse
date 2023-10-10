FROM openjdk:17
ADD target/clustered-warehouse-service.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]