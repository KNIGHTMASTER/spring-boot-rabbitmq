FROM openjdk:8-jre-alpine

COPY target/*.jar /app/subscriber-two.jar
WORKDIR /app

ENTRYPOINT ["java", "-jar", "subscriber-two.jar"]

EXPOSE 8080/tcp
