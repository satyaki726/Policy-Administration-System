FROM openjdk:8
ADD target/discovery-server.jar discovery-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","discovery-server.jar"]