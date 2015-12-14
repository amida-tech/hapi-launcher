FROM java:8
MAINTAINER  Mike Hiner <mike.hiner@gmail.com>

COPY hapi-fhir/* /opt/hapi-fhir/
WORKDIR /opt/hapi-fhir
EXPOSE 8080
# setting war file and path to use as environment variables 
# so they can be over ridden at the instance level
# the war file to use (default hapi-fhir-test.war)
ENV WAR_FILE="hapi-fhir-test.war" 
# the path to use for the war (default fhir-test)
ENV URL_PATH="fhir-test"
CMD ["/opt/hapi-fhir/hapi-docker.sh", "start"]