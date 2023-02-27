FROM amazoncorretto:ll-alpine-jdk
MAINTAINER ENUAR
COPY target/transportes.jar transportes.jar
ENTRYPOINT ["java","-jar","/transportes.jar"]

