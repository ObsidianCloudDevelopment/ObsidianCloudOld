package de.obsidiancloud.api.task;

public enum TaskType {
    SNAPSHOT("snapshot.jar", "server.jar"),
    BUKKIT("bukkit.jar", "spigot.jar", "paper.jar", "pufferfish.jar", "purpur.jar"),
    BUNGEECORD("bungeecord.jar", "waterfall.jar", "travertine.jar", "hexacord.jar"),
    VELOCITY("velocity.jar");

    private final String[] jarNames;

    TaskType(String... jarNames) {
        this.jarNames = jarNames;
    }

    public String[] getJarNames() {
        return jarNames;
    }
}