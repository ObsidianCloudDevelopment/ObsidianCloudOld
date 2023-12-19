package de.obsidiancloud.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class YamlConfigSection {
    protected abstract Map<String, Object> getConfig();

    public Object get(String path, Object defaultValue) {
        if (path == null) return false;
        if (path.contains(".")) {
            YamlConfigSection section = getSection(path.split("\\.")[0]);
            return section == null ? defaultValue : section.get(path.substring(path.indexOf(".") + 1), defaultValue);
        } else return getConfig().getOrDefault(path, defaultValue);
    }

    public void set(String path, Object value) {
        if (path == null) return;
        if (path.contains(".")) {
            YamlConfigSection section = getSection(path.split("\\.")[0]);
            if (section == null) {
                section = new YamlConfigSectionImpl(new HashMap<>());
                getConfig().put(path.split("\\.")[0], section);
            }
            section.set(path.substring(path.indexOf(".") + 1), value);
        } else getConfig().put(path, value);
    }

    public boolean has(String path) {
        return get(path, null) != null;
    }

    public String getString(String path, String defaultValue) {
        Object object = get(path, defaultValue);
        return object instanceof String value ? value : defaultValue;
    }

    public boolean getBoolean(String path, boolean defaultValue) {
        Object object = get(path, defaultValue);
        return object instanceof Boolean value ? value : defaultValue;
    }

    public int getInt(String path, int defaultValue) {
        Object object = get(path, defaultValue);
        return object instanceof Integer value ? value : defaultValue;
    }

    public long getLong(String path, long defaultValue) {
        Object object = get(path, defaultValue);
        return object instanceof Long value ? value : defaultValue;
    }

    public float getFloat(String path, float defaultValue) {
        Object object = get(path, defaultValue);
        return object instanceof Float value ? value : defaultValue;
    }

    public double getDouble(String path, double defaultValue) {
        Object object = get(path, defaultValue);
        return object instanceof Double value ? value : defaultValue;
    }

    @SuppressWarnings("unchecked")
    public YamlConfigSection getSection(String path) {
        Object object = get(path, null);
        return object instanceof Map<?, ?> map ? new YamlConfigSectionImpl(new HashMap<>((Map<String, Object>) map)) : null;
    }

    public Set<String> getKeys() {
        return getConfig().keySet();
    }

    private static class YamlConfigSectionImpl extends YamlConfigSection {
        private Map<String, Object> config;

        public YamlConfigSectionImpl(Map<String, Object> config) {
            this.config = config;
        }

        @Override
        protected Map<String, Object> getConfig() {
            return config;
        }
    }
}