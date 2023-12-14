package de.obsidiancloud.api.player;

import java.util.UUID;

public class ObsidianPlayer {
    private UUID uniqueId;
    private String name;

    public ObsidianPlayer(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
    }

    // Getter
    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }
}
