package de.obsidiancloud.common;

import de.obsidiancloud.common.command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Console extends Thread {
    private static final List<Command> commands = new ArrayList<>();
    private String defaultPrompt;

    public Console(String defaultPrompt) {
        this.defaultPrompt = defaultPrompt;
    }

    @Override
    public void run() {
        while (true) {
            String line = System.console().readLine(defaultPrompt);
            if (line == null) break;
            String[] pieces = line.split(" ");
            if (pieces.length == 0) continue;
            for (Command command : commands) {
                if (command.getName().equalsIgnoreCase(pieces[0])) {
                    command.execute(Arrays.copyOfRange(pieces, 1, pieces.length - 1));
                    break;
                }
                boolean shouldBreak = false;
                for (String alias : command.getAliases()) {
                    if (alias.equalsIgnoreCase(pieces[0])) {
                        command.execute(Arrays.copyOfRange(pieces, 1, pieces.length - 1));
                        shouldBreak = true;
                    }
                }
                break;
            }
        }
    }

    public String sendHelp() {
        String help =   "stop <|> Stop the cloud" +
                        "help <|> Send you this help page";
        return help;
    }

    public static synchronized List<Command> getCommands() {
        return commands;
    }

    public static synchronized void registerCommand(Command command) {
         commands.add(command);
    }
}