#!/bin/sh

JACKRABBIT_JAR=/opt/git/jackrabbit/jackrabbit-standalone/target/jackrabbit-standalone-2.2.5-SNAPSHOT.jar

javac  -Xlint:deprecation  -cp  $JACKRABBIT_JAR src/Client.java src/ch/liip/jcr/davex/DavexClient.java  src/ch/liip/jcr/davex/RepositoryConfigImplTest.java src/ch/liip/jcr/davex/AbstractRepositoryConfig.java   
cd src 
jar cf Client.jar Client.class ch/liip/jcr/davex/*.class 
cd .. 
java -cp  $JACKRABBIT_JAR:./src/Client.jar Client
