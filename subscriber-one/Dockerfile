FROM openjdk:8-jre-alpine

COPY target/*.jar /app/subscriber-one.jar
WORKDIR /app

ENTRYPOINT ["java", "-jar", "subscriber-one.jar"]

EXPOSE 8080/tcp
