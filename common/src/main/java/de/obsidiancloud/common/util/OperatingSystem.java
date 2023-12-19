package de.obsidiancloud.common.util;

public enum OperatingSystem {
    WINDOWS("(C:\\\\)?([a-zA-z0-9!§$%&(){}\\[\\]=@+#',;.\\-_]\\\\?)+"),
    LINUX("/?([a-zA-z0-9!§$%&(){}\\[\\]=@+#',;.\\-_]/?)+"),
    OTHER(null);

    private String fileRegex;

    OperatingSystem(String fileRegex) {
        this.fileRegex = fileRegex;
    }

    public String getFileRegex() {
        return fileRegex;
    }

    public static OperatingSystem getOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) return WINDOWS;
        else if (os.contains("unix") || os.contains("linux")) return LINUX;
        else return OTHER;
    }
}