package de.obsidiancloud.api.servers;

import java.util.UUID;

public class ObsidianServer {
    private UUID uniqueId;
    private String name;
    private ServerState state;
    private int maxPlayers;
    private int ram;

    // Getter
    public ServerState getState() {
        return state;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    // Setter
    public void setState(ServerState state) {
        this.state = state;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
