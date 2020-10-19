#!/usr/bin/env bash

echo "Generating all jar files"
mvn clean package

echo "Build and Running Containers"
docker-compose up --build