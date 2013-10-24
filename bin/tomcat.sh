#!/bin/sh
echo [INFO] Use maven tomcat-plugin run the project.
cd ..

export MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m
mvn tomcat:run -Dmaven.tomcat.port=8080
cd bin