#!/usr/bin/env bash

REPOSITORY=/home/ubuntu/neonadeuri
cd $REPOSITORY

APP_NAME=cicd-test
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep 'SNAPSHOT.JAR' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할것 없음."
else
  echo "> kill -9 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> $JAR_PATH 배포"
nohub java -jar $JAR_PATH > /dev/null 2> /dev/null < /devl/null &
