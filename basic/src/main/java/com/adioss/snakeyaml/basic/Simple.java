package com.adioss.snakeyaml.basic;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Map;

public class Simple {
    private static final URL RESOURCE = Simple.class.getClassLoader().getResource("boom.yaml");
    private static final String FILE = RESOURCE.getFile();

    public static void main(String[] args) {
        Yaml yaml = new Yaml(new SafeConstructor());
        try (InputStream io = isResourceAvailable() ? new FileInputStream(FILE) : RESOURCE.openStream()) {
            Map load = yaml.load(io);
            System.out.println(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isResourceAvailable() {
        boolean exists = false;
        try {
            exists = Files.exists(new File(FILE).toPath());
        } catch (Exception e) {
            //
        }
        return exists;
    }
}
