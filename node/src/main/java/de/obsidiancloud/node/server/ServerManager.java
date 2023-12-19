package de.obsidiancloud.node.server;

import de.obsidiancloud.api.ObsidianCloudAPI;
import de.obsidiancloud.api.servers.ObsidianServer;
import de.obsidiancloud.api.servers.ServerState;
import de.obsidiancloud.api.task.ObsidianTask;

public class ServerManager {
    public static void createServerFromTask(ObsidianTask task) {
        ObsidianServer server = new ObsidianServer(generateName(task), ServerState.STARTING, task, task.maxPlayers(), task.staticServers());
    }

    private static String generateName(ObsidianTask task) {
        int i = 0;
        while (ObsidianCloudAPI.getServer(task.name() + "-" + i) != null) i++;
        return task.name() + "-" + i;
    }
}