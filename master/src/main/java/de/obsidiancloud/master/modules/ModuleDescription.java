package de.obsidiancloud.master.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleDescription {
    public static final List<ModuleDescription> descriptions = new ArrayList<>();

    private final String name;

    private final String main;

    private final String version;

    private final String author;

    public ModuleDescription(String name, String main, String version, String author) {
        this.name = name;
        this.main = main;
        this.version = version;
        this.author = author;
        descriptions.add(this);
    }

    public String getName() {
        return this.name;
    }

    public String getMain() {
        return this.main;
    }

    public String getVersion() {
        return this.version;
    }

    public String getAuthor() {
        return this.author;
    }
}
