FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/diabetes-anticipator-microservice-0.0.1-SNAPSHOT.jar diabetes-anticipator-microservice.jar
ENTRYPOINT ["java", "-jar", "/diabetes-anticipator-microservice.jar"]