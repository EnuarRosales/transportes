#
# Build stage
#
FROM amazoncorretto:ll-alpine-jdk
MAINTAINER ENUAR
COPY target  transportes.jar
ENTRYPOINT ["java","-jar","/transportes.jar"]

