package de.obsidiancloud.master;

import de.obsidiancloud.common.cli.CLI;
import de.obsidiancloud.common.cli.Command;
import de.obsidiancloud.common.config.YamlConfig;
import de.obsidiancloud.common.util.Logger;
import de.obsidiancloud.master.commands.ShutdownCommand;

import java.io.File;

public class ObsidianCloudMaster {
    public static Logger LOGGER = new Logger("main");
    private static YamlConfig config;

    public static void main(String[] args) {
        LOGGER.info("Welcome to ObsidianCloud");
        LOGGER.info("Starting master...");
        config = new YamlConfig();
        config.load(new File("config.yml"));
        Command.register(new ShutdownCommand());
        CLI.setDefaultPrompt("> ");
        CLI.setWrongCommandMessage("Unknown command. Type \"help\" for help.");
        CLI.start();
    }

    public static YamlConfig getConfig() {
        return config;
    }
}