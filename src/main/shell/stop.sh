#!/usr/bin/env bash
LANG=zh_CN.UTF-8;export LANG
PROJECT_NAME=@projectName@

for pid in $(ps -ef |grep ${PROJECT_NAME} | grep -v "grep" | awk ' { print $2 } ')
do
kill -9 "$pid";
echo "$pid";
done