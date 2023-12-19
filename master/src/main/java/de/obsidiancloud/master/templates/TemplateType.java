package de.obsidiancloud.master.templates;
public enum TemplateType {
    PROXY("Proxy"),
    SUB_PROXY("SubProxy"),
    LOBBY("Lobby"),
    GAME_SERVER("GameServer"),
    OTHER("Other");

    String name;

    TemplateType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
