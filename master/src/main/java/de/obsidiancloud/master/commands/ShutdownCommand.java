package de.obsidiancloud.master.commands;

import de.obsidiancloud.common.cli.CLI;
import de.obsidiancloud.common.cli.Command;
import de.obsidiancloud.master.ObsidianCloudMaster;

public class ShutdownCommand extends Command {
    public ShutdownCommand() {
        super("shutdown", "exit");
    }

    @Override
    public void execute(String[] args) {
        ObsidianCloudMaster.LOGGER.info("Shutting down...");
        CLI.stop();
    }
}
