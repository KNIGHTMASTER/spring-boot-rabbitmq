FROM openjdk:8-jre-alpine

COPY ./target/*.jar /app/producer.jar
WORKDIR /app

ENTRYPOINT ["java", "-jar", "producer.jar"]

EXPOSE 8080/tcp
