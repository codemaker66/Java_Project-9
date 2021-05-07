FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/patient-microservice-0.0.1-SNAPSHOT.jar patient-microservice.jar
ENTRYPOINT ["java", "-jar", "/patient-microservice.jar"]