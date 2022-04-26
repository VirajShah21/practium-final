#!/usr/bin/env bash

kill -9 $(lsof -t -i:8080)

./jdk-14.0.2/bin/java -jar practium-final-0.0.1-SNAPSHOT.jar