FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/mediscreen-0.0.1-SNAPSHOT.jar mediscreen.jar
ENTRYPOINT ["java", "-jar", "/mediscreen.jar"]