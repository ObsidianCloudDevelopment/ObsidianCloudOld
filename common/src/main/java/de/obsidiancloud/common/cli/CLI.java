package de.obsidiancloud.common.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CLI implements Runnable {
    private static Scanner scanner;
    private static Thread thread = null;
    private static String defaultPrompt = "";
    private static String wrongCommandMessage = "";

    @Override
    public void run() {
        String line;
        while ((line = readLine(defaultPrompt)) != null) {
            String[] pieces = line.split(" ");
            if (pieces.length == 0) continue;
            boolean commandFound = false;
            for (Command command : Command.getCommands()) {
                if (command.getName().equalsIgnoreCase(pieces[0])) {
                    commandFound = true;
                    command.execute(pieces.length == 1 ? pieces : Arrays.copyOfRange(pieces, 1, pieces.length - 1));
                    break;
                }
                boolean shouldBreak = false;
                for (String alias : command.getAliases()) {
                    if (alias.equalsIgnoreCase(pieces[0])) {
                        commandFound = true;
                        command.execute(pieces.length == 1 ? pieces : Arrays.copyOfRange(pieces, 1, pieces.length - 1));
                        shouldBreak = true;
                    }
                }
                if (shouldBreak) break;
            }
            if (!commandFound) System.out.printf(wrongCommandMessage + "\n", pieces[0]);
        }
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return readLine();
    }

    public static String readLine() {
        if (scanner == null) scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void start() {
        if (thread == null) {
            thread = new Thread(new CLI());
            thread.start();
        }
    }

    @SuppressWarnings("deprecation")
    public static void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }

    public static String getDefaultPrompt() {
        return defaultPrompt;
    }

    public static void setDefaultPrompt(String defaultPrompt) {
        CLI.defaultPrompt = defaultPrompt;
    }

    public static String getWrongCommandMessage() {
        return wrongCommandMessage;
    }

    public static void setWrongCommandMessage(String wrongCommandMessage) {
        CLI.wrongCommandMessage = wrongCommandMessage;
    }
}