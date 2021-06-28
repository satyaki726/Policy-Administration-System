FROM openjdk:8
ADD target/authorization-microservice.jar authorization-microservice.jar
EXPOSE 8400
ENTRYPOINT ["java","-jar","authorization-microservice.jar"]