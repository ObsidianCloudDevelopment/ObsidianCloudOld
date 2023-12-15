package de.obsidiancloud.master;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.util.logging.Logger;

public class ObsidianCloudMaster {
    private static Logger LOGGER;

    public static void main(String[] args) {
        try {
            Terminal terminal = TerminalBuilder.builder().build();
            terminal.writer().println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}