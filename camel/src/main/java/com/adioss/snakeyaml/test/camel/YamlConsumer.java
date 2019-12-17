package com.adioss.snakeyaml.test.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.model.dataformat.YAMLLibrary;

/**
 * java -cp target/camel-1.0-SNAPSHOT.jar com.adioss.snakeyaml.test.camel.YamlConsumer {FOLDER_TO_PARSE}
 */
public class YamlConsumer {

    private static void start(String path) throws Exception {
        Main main = new Main();

        main.addRouteBuilder(new RouteBuilder() {
            @Override
            public void configure() {
                from("file://" + path + "?noop=true")
                        .unmarshal().yaml(YAMLLibrary.SnakeYAML)
                        .log(LoggingLevel.INFO, "${body}");
            }
        });

        main.run();
        // main.start();
    }

    public static void main(String... args) throws Exception {
        String defaultPath;
        if (args.length == 0) {
            defaultPath = YamlConsumer.class.getClassLoader().getResource("payloads").getPath();
        } else {
            defaultPath = args[0];
        }

        start(defaultPath);
    }
}
