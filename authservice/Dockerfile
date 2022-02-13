# FROM openjdk:8-slim as build
FROM openjdk:8-jdk-alpine as build

MAINTAINER manoj.com

COPY target/authservice-0.0.1-SNAPSHOT.jar authservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/authservice-0.0.1-SNAPSHOT.jar"]