package de.obsidiancloud.common.config;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YamlConfig extends YamlConfigSection {
    private Map<String, Object> config = new HashMap<>();

    @Override
    protected Map<String, Object> getConfig() {
        return config;
    }

    public void load(File file) {
        if (file == null || !file.exists()) return;
        try {
            load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(InputStream inputStream) {
        if (inputStream == null) return;
        config = new Yaml().load(inputStream);
    }

    public void save(File file) {
        if (file == null) return;
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            save(new FileWriter(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Writer writer) {
        if (writer == null) return;
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        new Yaml(options).dump(config, writer);
    }
}