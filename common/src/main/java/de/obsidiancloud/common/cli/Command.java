package de.obsidiancloud.common.cli;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    private static final List<Command> commands = new ArrayList<>();

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

    public static synchronized List<Command> getCommands() {
        return commands;
    }

    public static synchronized void register(Command command) {
        synchronized (command) {
            commands.add(command);
        }
    }
}