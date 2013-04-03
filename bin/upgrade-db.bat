@echo off
echo [INFO] dbdeploy:update the schema and provision the sample data.

cd %~dp0
cd ..

call mvn dbdeploy:update -Pupgrade-db

cd bin
pause