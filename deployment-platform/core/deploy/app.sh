#!/bin/bash

set -e

APP_NAME="simple-core"
ROOT=$(dirname $(readlink -e $0))

SCRIPT=$ROOT/bin/$APP_NAME
LOG_XML="$ROOT/config/logback.xml"

if [ -f $LOG_XML ]; then
    LOG_CONFIG="-Dlogback.configurationFile=$LOG_XML"
else
    LOG_CONFIG=""
fi

CONFIG_FILE="$ROOT/config/application.conf"

if [ -f $CONFIG_FILE ]; then
    CONFIG="-Dconfig.file=$ROOT/config/application.conf"
else
    CONFIG=""
fi

if [ -z "$2" ]; then
    N=0
else
    N=$2
fi

NN=$(printf %02d $N)

CC="-Dnode=$N -Dhttp.port=10$NN -Dakka.remote.netty.tcp.port=100$NN"

ID=$(uuidgen)
EXTRA="-Dapp-uuid=$ID"
RUN_DIR="/run/ady/${APP_NAME}/$N"
mkdir -pv ${RUN_DIR}
PID_FILE_NAME=${RUN_DIR}/${APP_NAME}-${ID}.pid

export JAVA_OPTS="-Xmx1G -Xms1G -server -XX:+UseG1GC $JAVA_OPTS"

RUN_COMMAND="bash $SCRIPT $CC $CONFIG $LOG_CONFIG $EXTRA"

function runServer() {
    nohup $RUN_COMMAND > /dev/null 2>&1 &
    sleep 2
    pid=$(ps -ef | grep "$ID" | grep -v grep | awk '{print $2}')
    if [ -n "$pid" ]; then
        echo $pid > $PID_FILE_NAME
        echo "server started. pid: $pid"
    else
        echo "starting failed!"
    fi
}

function runStop() {
    fs=$(ls $RUN_DIR | grep "${APP_NAME}-")
    for i in $(ls $RUN_DIR | grep "${APP_NAME}-")
    do
        pid=$(cat $RUN_DIR/$i)
        kill $pid || echo "process $pid not exist."
        rm -vfr $RUN_DIR/$i
        echo "service stopped. pid: $pid"
    done
}

function runRestart() {
    runStop && runServer
}

case $1 in
    run)
        $RUN_COMMAND
 	      ;;
    start | server)
        runServer
        ;;
    stop)
        runStop
        ;;
    restart)
        runRestart
        ;;
    *)
        $RUN_COMMAND
        ;;
esac

exit 0
