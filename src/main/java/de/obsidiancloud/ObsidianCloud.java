package de.obsidiancloud;

import de.obsidiancloud.master.ObsidianCloudMaster;
import de.obsidiancloud.node.ObsidianCloudNode;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class ObsidianCloud {
    public static void main(String[] args) {
        if (args.length == 0) {
            try {
                Terminal terminal = TerminalBuilder.builder().build();
                terminal.writer().println(
                        "╔═══╦╗───────╔╗───────╔═══╦╗────────╔╗\n" +
                        "║╔═╗║║───────║║───────║╔═╗║║────────║║\n" +
                        "║║─║║╚═╦══╦╦═╝╠╦══╦═╗─║║─╚╣║╔══╦╗╔╦═╝║\n" +
                        "║║─║║╔╗║══╬╣╔╗╠╣╔╗║╔╗╗║║─╔╣║║╔╗║║║║╔╗║\n" +
                        "║╚═╝║╚╝╠══║║╚╝║║╔╗║║║║║╚═╝║╚╣╚╝║╚╝║╚╝║\n" +
                        "╚═══╩══╩══╩╩══╩╩╝╚╩╝╚╝╚═══╩═╩══╩══╩══╝");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("master")) {
            ObsidianCloudMaster.main(args);
        } else if (args[0].equals("node")) {
            ObsidianCloudNode.main(args);
        }
    }
}