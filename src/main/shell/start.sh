#!/usr/bin/env bash
LANG=zh_CN.UTF-8;export LANG
JAVA_HOME=@javaHome@
WORK_HOME=@workHome@
LOG_HOME=${WORK_HOME}/log


sh stop.sh
sleep 1
nohup ${JAVA_HOME}/bin/java -jar ${WORK_HOME}/manage90-0.0.1-SNAPSHOT.jar >> ${LOG_HOME}/start.log$(date +%y%m%d) &