#!/usr/bin/env bash

cd /go/src/lbg.com/open-policy-agent
go build -buildmode=c-shared -o libopa.so libopa.go

cd /go/src/lbg.com/open-policy-agent/java
mvn -Dmaven.repo.local=../.m2 -B clean install

java -jar target/jnr-opa-*.jar
