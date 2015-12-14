#!/bin/bash
#WAR_FILE=${2:-hapi-fhir-test.war}
#URL_PATH=${3:fhir-test}

case "$1" in
    start)

    # first kill any servers that may be running 
    pkill -f "java -jar fhirTest-0.0.6.jar $WAR_FILE $URL_PATH"
    # start the server
    java -jar fhirTest-0.0.6.jar $WAR_FILE $URL_PATH> server.log 2>&1 &
    # follow the log file until the server is started
    echo "starting server"
    tail -f server.log 
    ;;
    stop)
    pkill -f "java -jar fhirTest-0.0.6.jar $WAR_FILE $URL_PATH"
    ;;
    *)
    echo "Usage: $0 {start|stop}"
    exit 1
    ;;
esac

exit 0
