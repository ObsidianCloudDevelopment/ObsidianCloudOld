package de.obsidiancloud.setup;

import org.bson.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MasterSetup {
    private static final Scanner scanner = new Scanner(System.in);
    private static Document config = new Document();
    private static File configFile = new File("config.json");

    public static void run() throws Exception{
        while (true) {
            print("Setup. Please follow the instructions.");
            print("Wich should be the clouds communication port? (Default: 3434)");
            String line = scanner.nextLine();
            config.append("port", line.isEmpty() ? 3434 : Integer.parseInt(line));
            clearConsole();
            print("What is your Server IP where the cloud is running? (Default: 172.0.0.1)");
            line = scanner.nextLine();
            config.append("ip", line.isEmpty() ? "172.0.0.1" : Integer.parseInt(line));
            clearConsole();
            writeFile(configFile, config);
            return;
        }
    }

    //Utils
    private static void clearConsole() throws Exception {
        if (System.getProperty("os.name").contains("Windows")) {
            (new ProcessBuilder(new String[] { "cmd", "/c", "cls" })).inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

    public static void print(String s) {
        System.out.println("Setup > " + s);
    }

    public static void writeFile(File file, Document document) throws Exception {
        if (file.exists())
            file.delete();
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(document.toJson());
        writer.close();
    }
}