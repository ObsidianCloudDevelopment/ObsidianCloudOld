package de.obsidiancloud.common.cli;

import java.util.Arrays;
import java.util.Scanner;

public class CLI implements Runnable {
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
                    command.execute(Arrays.copyOfRange(pieces, 1, pieces.length - 1));
                    break;
                }
                boolean shouldBreak = false;
                for (String alias : command.getAliases()) {
                    if (alias.equalsIgnoreCase(pieces[0])) {
                        commandFound = true;
                        command.execute(Arrays.copyOfRange(pieces, 1, pieces.length - 1));
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
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNext() ? scanner.nextLine() : null;
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
}