#!/usr/bin/env bash

echo "Stopping Containers"
docker-compose down

echo "removing images"
docker image rm spring-boot-rabbitmq_subscriber-one:latest
docker image rm spring-boot-rabbitmq_subscriber-two:latest
docker image rm spring-boot-rabbitmq_producer:latest
docker image rm spring-boot-rabbitmq_rabbitmq:latest
