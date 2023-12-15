package de.obsidiancloud.master.modules;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<ObsidianModule> modules = new ArrayList<>();
    private static File dir = new File("modules/");

    public void loadModules() throws IOException {
        for (File file : dir.listFiles()) {
            if (file.getName().toLowerCase().endsWith(".jar")) {

            }
        }
    }

    public List<ObsidianModule> getModules() {
        return modules;
    }

}
