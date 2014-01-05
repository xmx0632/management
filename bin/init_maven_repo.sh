#!/bin/sh
echo [INFO] install springside jar to m2 repo.
cd ..
mvn install:install-file -Dfile=./lib/springside-core-4.1.0.jar -DgroupId=org.springside -DartifactId=springside-core -Dversion=4.1.0 -Dpackaging=jar
mvn install:install-file -Dfile=./lib/springside-extension-4.1.0.jar -DgroupId=org.springside -DartifactId=springside-extension -Dversion=4.1.0 -Dpackaging=jar
mvn install:install-file -Dfile=./lib/springside-test-4.1.0.jar -DgroupId=org.springside -DartifactId=springside-test -Dversion=4.1.0 -Dpackaging=jar
mvn install:install-file -Dfile=./lib/springside-core-4.1.0-sources.jar -DgroupId=org.springside -DartifactId=springside-core -Dversion=4.1.0 -Dpackaging=jar -Dclassifier=sources
mvn install:install-file -Dfile=./lib/springside-extension-4.1.0-sources.jar -DgroupId=org.springside -DartifactId=springside-extension -Dversion=4.1.0 -Dpackaging=jar -Dclassifier=sources
mvn install:install-file -Dfile=./lib/springside-test-4.1.0-sources.jar -DgroupId=org.springside -DartifactId=springside-test -Dversion=4.1.0 -Dpackaging=jar -Dclassifier=sources
cd bin