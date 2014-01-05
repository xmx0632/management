#!/bin/sh
echo [INFO] dbdeploy:update the schema and provision the sample data.

cd ..
mvn dbdeploy:update -Pupgrade-db
cd bin
