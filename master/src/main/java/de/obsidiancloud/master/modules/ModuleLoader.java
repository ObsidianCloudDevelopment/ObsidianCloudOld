package de.obsidiancloud.master.modules;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ModuleLoader {
    private ModuleManager manager;

    public ModuleLoader(ModuleManager manager) {
        this.manager = manager;
    }

    public void initModule(String file, ModuleDescription description) {
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[] { this.findModule(file).toURI().toURL() }, getClass().getClassLoader());
            Class<?> clazz = Class.forName(description.getMain(), true, classLoader);
            if (clazz.isEnum() || clazz.isInterface())
                return;
            Object instance = clazz.newInstance();
            if (!(instance instanceof ObsidianModule))
                return;
            ObsidianModule module = (ObsidianModule)instance;
            module.onEnable();
            this.manager.getModules().add(module);
        } catch (Exception e) {
            //FAILED ENABLE MODULE
            e.printStackTrace();
        }
    }

    public File findModule(String name) {
        return new File("modules/" + name);
    }
}
