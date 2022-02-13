# FROM openjdk:8-slim as build
FROM openjdk:8-jdk-alpine as build

MAINTAINER manoj.com

COPY target/usermgt-0.0.1-SNAPSHOT.jar usermgt-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/usermgt-0.0.1-SNAPSHOT.jar"]