#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build

MAINTAINER ENUAR

COPY target/transportes-0.0.1-SNAPSHOT.jar transportes.jar
ENTRYPOINT ["java","-jar","/transportes.jar"]

