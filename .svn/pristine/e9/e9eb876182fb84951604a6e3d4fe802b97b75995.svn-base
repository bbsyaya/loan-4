#!/bin/bash

export CLASSPATH=.
export SOURCE_HOME=/home/hrbbif/webtools

export CLASSPATH=${CLASSPATH}:${SOURCE_HOME}/loan-pos-tools-1.0.0-SNAPSHOT-jar-with-dependencies.jar

cd $SOURCE_HOME

/usr/java/default/bin/java -classpath ${CLASSPATH} com.hrbb.loan.pos.tools.main.PosLoanMessagePush &
