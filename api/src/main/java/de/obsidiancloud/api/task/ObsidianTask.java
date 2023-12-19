package de.obsidiancloud.api.task;

import java.util.List;

public record ObsidianTask(String name, TaskType type, List<String> associatedNodes, boolean staticServers, List<String> templates, int ram, int minOnline, int maxPlayers, boolean maintenance) {
}