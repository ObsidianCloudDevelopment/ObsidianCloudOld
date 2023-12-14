package de.obsidiancloud.common.command;

public abstract class Command {
    private final String name;
    private final String[] aliases;

    public Command(String name, String... aliases) {
        this.name = name;
        this.aliases = aliases;
    }

    public abstract void execute(String[] args);

    public String getName() {
        return name;
    }

    public String[] getAliases() {
        return aliases;
    }
}