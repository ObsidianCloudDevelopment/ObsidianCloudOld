package de.obsidiancloud.setup;

import de.obsidiancloud.ObsidianCloud;
import de.obsidiancloud.common.cli.CLI;

public class ObsidianCloudSetup {
    public static void run() {
        ObsidianCloud.LOGGER.config("What you want to setup? [master/node/exit]");
        String answer = CLI.readLine();
        if ("master".startsWith(answer.toLowerCase())) MasterSetup.run();
        else if ("node".startsWith(answer.toLowerCase())) NodeSetup.run();
        else ObsidianCloud.LOGGER.config("Setup aborted!");
    }
}