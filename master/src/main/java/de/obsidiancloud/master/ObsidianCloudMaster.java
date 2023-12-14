package de.obsidiancloud.master;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class ObsidianCloudMaster {
    public static void main(String[] args) {
        try {
            Terminal terminal = TerminalBuilder.builder().build();
            terminal.writer().println("╔═══╦╗───────╔╗───────╔═══╦╗────────╔╗\n" +
                    "║╔═╗║║───────║║───────║╔═╗║║────────║║\n" +
                    "║║─║║╚═╦══╦╦═╝╠╦══╦═╗─║║─╚╣║╔══╦╗╔╦═╝║\n" +
                    "║║─║║╔╗║══╬╣╔╗╠╣╔╗║╔╗╗║║─╔╣║║╔╗║║║║╔╗║\n" +
                    "║╚═╝║╚╝╠══║║╚╝║║╔╗║║║║║╚═╝║╚╣╚╝║╚╝║╚╝║\n" +
                    "╚═══╩══╩══╩╩══╩╩╝╚╩╝╚╝╚═══╩═╩══╩══╩══╝");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}