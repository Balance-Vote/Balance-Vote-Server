#!/bin/sh

# deploy.sh
# deploy .jar

REPOSITORY=/home/ubuntu/deploy

cd $REPOSITORY

JAR_NAME=$(ls $REPOSITORY/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/$JAR_NAME

echo "> $JAR_PATH deploy"
nohup java -jar $JAR_PATH 2>&1 &
