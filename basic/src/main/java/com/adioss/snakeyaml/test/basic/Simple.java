package com.adioss.snakeyaml.test.basic;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class Simple {
    private static final String FILE = Simple.class.getClassLoader().getResource("k8s_billion.yaml").getFile();

    public static void main(String[] args) {
        Yaml yaml = new Yaml(new SafeConstructor());
        try (FileInputStream fileInputStream = new FileInputStream(FILE)) {
            Map load = yaml.load(fileInputStream);
            System.out.println(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
