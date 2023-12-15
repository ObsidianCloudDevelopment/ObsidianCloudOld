package de.obsidiancloud.setup;

import de.obsidiancloud.common.cli.CLI;

public class ObsidianCloudSetup {
    public static void run() {
        String answer = CLI.readLine("Welcome to Obsidian Cloud!\n\nWould you like to start the setup? [y/n] ");
        if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("yes") &&
                !answer.equalsIgnoreCase("t") && !answer.equalsIgnoreCase("true")) {
            System.out.println("Setup aborted.");
            return;
        }
        try {
            MasterSetup.run();
        } catch (Exception e) {
            System.out.println("[ERROR] An error occurred while running the setup!");
            throw new RuntimeException(e);
        }
    }
}