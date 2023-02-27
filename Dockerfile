#
# Build stage
#
FROM amazoncorretto:ll-alpine-jdk
MAINTAINER ENUAR
COPY target/0.0.1-SNAPSHOT.jar transportes.jar
ENTRYPOINT ["java","-jar","/transportes.jar"]

