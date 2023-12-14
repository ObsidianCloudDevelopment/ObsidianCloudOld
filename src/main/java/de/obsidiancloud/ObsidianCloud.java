package de.obsidiancloud;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class ObsidianCloud {
    public static void main(String[] args) {
        if (args.length == 0) {
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
        } else if (args[0].equals("master")) {
        } else if (args[0].equals("node")) {
        }
    }
}