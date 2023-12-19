package de.obsidiancloud.api.servers;

import de.obsidiancloud.api.task.ObsidianTask;

public record ObsidianServer(String name, ServerState state, ObsidianTask task, int maxPlayers, boolean staticServer) {
}