# How to use it
* build
``` 
mvn clean package
```
* launch
```
com.adioss.snakeyaml.test.camel.YamlConsumer.main 
or
java -cp camel-1.0-SNAPSHOT.jar com.adioss.snakeyaml.test.camel.YamlConsumer {FOLDER_TO_PARSE}
```
* by default, parsed files are located in folder:
```
target/classes/resources/payloads
```
