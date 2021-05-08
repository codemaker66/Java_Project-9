FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/practitioner-microservice-0.0.1-SNAPSHOT.jar practitioner-microservice.jar
ENTRYPOINT ["java", "-jar", "/practitioner-microservice.jar"]