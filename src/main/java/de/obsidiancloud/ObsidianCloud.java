package de.obsidiancloud;

import de.obsidiancloud.common.util.Logger;
import de.obsidiancloud.common.util.OperatingSystem;
import de.obsidiancloud.master.ObsidianCloudMaster;
import de.obsidiancloud.node.ObsidianCloudNode;
import de.obsidiancloud.setup.ObsidianCloudSetup;

public class ObsidianCloud {
    public static Logger LOGGER = new Logger("main");

    public static void main(String[] args) {
        if (OperatingSystem.getOS() == OperatingSystem.OTHER) {
            LOGGER.error("Your operating system is not supported!");
        } else if (args.length == 0) {
            LOGGER.warn(
                    "Usage:\n" +
                    "java -jar ObsidianCloud.jar master   ->  ObsidianCloud Master\n" +
                    "java -jar ObsidianCloud.jar node     ->  ObsidianCloud Node\n" +
                    "java -jar ObsidianCloud.jar          ->  ObsidianCloud Setup\n"
            );
            ObsidianCloudSetup.run();
        } else if (args[0].equals("master")) {
            ObsidianCloudMaster.main(args);
        } else if (args[0].equals("node")) {
            ObsidianCloudNode.main(args);
        }
    }
}