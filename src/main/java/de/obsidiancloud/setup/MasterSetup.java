package de.obsidiancloud.setup;

import de.obsidiancloud.ObsidianCloud;
import de.obsidiancloud.common.cli.CLI;
import de.obsidiancloud.common.config.YamlConfig;
import de.obsidiancloud.common.util.Logger;
import de.obsidiancloud.common.util.OperatingSystem;
import de.obsidiancloud.common.util.RegularExpressions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Scanner;

public class MasterSetup {
    private static Logger LOGGER = new Logger("MasterSetup");

    public static void run() {
        String directory;
        do {
            LOGGER.config("In which directory should be the master installed? (master)");
            directory = CLI.readLine();
        } while (!directory.matches(OperatingSystem.getOS().getFileRegex()) || (new File(directory).exists() && !new File(directory).isDirectory()));

        String defaultHost;
        try (Scanner scanner = new Scanner(new URL("https://checkip.amazonaws.com").openStream())) {
            defaultHost = scanner.nextLine();
        } catch (Exception e) {defaultHost = "127.0.0.1";}
        String host;
        do {
            LOGGER.config("What is your ip? (" + defaultHost + ")");
            host = CLI.readLine();
        } while (!host.matches(RegularExpressions.IP_ADDRESS));

        String port;
        do {
            LOGGER.config("What should be the communication port for the master? (1405)");
            port = CLI.readLine();
        } while (!port.matches(RegularExpressions.PORT) || Integer.parseInt(port) > 65535);

        new File(directory).mkdirs();
        YamlConfig config = new YamlConfig();
        config.set("host", host);
        config.set("port", Integer.parseInt(port));
        config.save(new File(new File(directory), "config.yml"));
        String startScript = OperatingSystem.getOS() == OperatingSystem.WINDOWS ? "start.bat" : "start.sh";
        try {
            Files.write(new File(new File(directory), startScript).toPath().toAbsolutePath(), "java -jar ObsidianCloud.jar master".getBytes());
            File from = new File(ObsidianCloud.class.getProtectionDomain().getCodeSource().getLocation().getFile());
            File to = new File(new File(directory), "ObsidianCloud.jar");
            if (OperatingSystem.getOS() == OperatingSystem.LINUX) {
                Runtime.getRuntime().exec("chmod +x " + new File(new File(directory), startScript).getAbsolutePath());
                Runtime.getRuntime().exec("cp -r " + from.getAbsolutePath() + " " + to.getAbsolutePath());
            } else {
                Runtime.getRuntime().exec("cmd /C copy " + from.getAbsolutePath() + " " + to.getAbsolutePath());
            }
            LOGGER.config("Setup finished! You can start the master with " + new File(new File(directory), startScript).getPath());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}