#
# Build stage
#
FROM openjdk:8-jdk-alpine
MAINTAINER ENUAR
COPY target  transportes.jar
ENTRYPOINT ["java","-jar","/transportes.jar"]

