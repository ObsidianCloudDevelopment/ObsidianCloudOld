package de.obsidiancloud;

import de.obsidiancloud.master.ObsidianCloudMaster;
import de.obsidiancloud.node.ObsidianCloudNode;
import de.obsidiancloud.setup.ObsidianCloudSetup;

public class ObsidianCloud {
    public static void main(String[] args) {
        if (args.length == 0) {
            ObsidianCloudSetup.run();
        } else if (args[0].equals("master")) {
            ObsidianCloudMaster.main(args);
        } else if (args[0].equals("node")) {
            ObsidianCloudNode.main(args);
        }
    }
}