#
# Build stage
#
FROM openjdk:11-jdk-alpine
MAINTAINER ENUAR
COPY target/0.0.1-SNAPSHOT.jar transportes.jar
ENTRYPOINT ["java","-jar","/transportes.jar"]

