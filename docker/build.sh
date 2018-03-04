#!/usr/bin/env bash

cd /go/src/github.com/llofberg/opa-jnr
go build -buildmode=c-shared -o libopa.so libopa.go

cd /go/src/github.com/llofberg/opa-jnr/java
mvn -Dmaven.repo.local=../.m2 -B clean install

java -jar target/jnr-opa-*.jar
