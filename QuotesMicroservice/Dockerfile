FROM openjdk:8
ADD target/quotes-microservice.jar quotes-microservice.jar
EXPOSE 8123
ENTRYPOINT ["java","-jar","quotes-microservice.jar"]