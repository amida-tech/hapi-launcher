# HAPI Fhir server
	
## Usage

### Environment variables

- WAR_FILE : the war file to use.  The image by default includes hapi-fhir-test-memory.war and  hapi-fhir-test.war.  default is hapi-fhir-test.war
- URL_PATH : The path to use.  default is fhir-test

### Running 

to start a default server and expose it on 8080:

```bash
docker run -p 127.0.0.1:8080:8080 <docker image name>
```

to start with in memory db:

```
docker run -e "WAR_FILE=hapi-fhir-test-memory.war" -p 127.0.0.1:8080:8080 <docker image name>
```

to start with a custom path of "fhir"

```
docker run -it --rm -e "URL_PATH=fhir" -p 127.0.0.1:8080:8080 <docker image name>
```
