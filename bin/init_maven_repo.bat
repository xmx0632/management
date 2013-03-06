@echo off
echo [INFO] install springside jar to m2 repo.

cd %~dp0
cd ..
call mvn install:install-file -Dfile=./lib/springside-core-4.1.0-SNAPSHOT.jar -DgroupId=org.springside -DartifactId=springside-core -Dversion=4.1.0-SNAPSHOT -Dpackaging=jar
call mvn install:install-file -Dfile=./lib/springside-extension-4.1.0-SNAPSHOT.jar -DgroupId=org.springside -DartifactId=springside-extension -Dversion=4.1.0-SNAPSHOT -Dpackaging=jar
call mvn install:install-file -Dfile=./lib/springside-test-4.1.0-SNAPSHOT.jar -DgroupId=org.springside -DartifactId=springside-test -Dversion=4.1.0-SNAPSHOT -Dpackaging=jar
call mvn install:install-file -Dfile=./lib/springside-core-4.1.0-SNAPSHOT-sources.jar -DgroupId=org.springside -DartifactId=springside-core -Dversion=4.1.0-SNAPSHOT -Dpackaging=jar -Dclassifier=sources
call mvn install:install-file -Dfile=./lib/springside-extension-4.1.0-SNAPSHOT-sources.jar -DgroupId=org.springside -DartifactId=springside-extension -Dversion=4.1.0-SNAPSHOT -Dpackaging=jar -Dclassifier=sources
call mvn install:install-file -Dfile=./lib/springside-test-4.1.0-SNAPSHOT-sources.jar -DgroupId=org.springside -DartifactId=springside-test -Dversion=4.1.0-SNAPSHOT -Dpackaging=jar -Dclassifier=sources
pause