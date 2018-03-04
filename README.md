OPA embedded in JVM
===

Running ```docker-compose up``` will

- build a docker image
- run the docker image
- mount $GOROOT to /go in the docker image
- execute /go/src/github.com/llofberg/opa-jnr/docker/build.sh

build.sh will

- build libopa.so
- build jnr-opa-*.jar
- run jnr-opa-*.jar

jnr-opa-*.jar will
- load libopa.so
- run a thread in libopa.so (the thread will mostly sleep)
- compile a module in libopa.so
- query libopa.so with inputs
