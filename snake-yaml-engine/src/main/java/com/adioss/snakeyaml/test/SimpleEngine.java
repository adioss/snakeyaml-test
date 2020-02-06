package com.adioss.snakeyaml.test;

import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Map;

public class SimpleEngine {
    private static final URL RESOURCE = SimpleEngine.class.getClassLoader().getResource("boom.yaml");
    private static final String FILE = RESOURCE.getFile();

    public static void main(String[] args) {
        LoadSettings settings = LoadSettings.builder().setMaxAliasesForCollections(10).build();
        Load load = new Load(settings);
        try (InputStream io = isResourceAvailable() ? new FileInputStream(FILE) : RESOURCE.openStream()) {
            Map map = (Map) load.loadFromInputStream(io);
            System.out.println(map);
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
