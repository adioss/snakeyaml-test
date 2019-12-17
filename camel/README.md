# How to use it
* build
``` 
mvn clean package
```
* launch
```
com.adioss.snakeyaml.camel.YamlConsumer.main 
or
java -cp target/camel-1.0-SNAPSHOT.jar com.adioss.snakeyaml.camel.YamlConsumer {FOLDER_TO_PARSE}
```
* by default, parsed files are located in folder:
```
target/classes/resources/payloads
```
