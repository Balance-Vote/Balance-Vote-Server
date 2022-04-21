#!/bin/sh

# stop.sh
# kill current server

CURRENT_PID=$(pgrep -f BalanceVote*.jar)

if [ -z $CURRENT_PID ]
then
  echo "> Nothing to end."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi