package de.obsidiancloud.common.util;

public record Logger(String name) {
    public void info(Object message, Object... args) {
        System.out.println(AnsiColors.ANSI_LIGHT_WHITE + "[" + name + "/" + AnsiColors.ANSI_LIGHT_BLUE + "INFO" + AnsiColors.ANSI_LIGHT_WHITE + "] " + message.toString().formatted(args));
    }

    public void warn(Object message, Object... args) {
        System.out.println(AnsiColors.ANSI_LIGHT_WHITE + "[" + name + "/" + AnsiColors.ANSI_LIGHT_YELLOW + "WARN" + AnsiColors.ANSI_LIGHT_WHITE + "] " + AnsiColors.ANSI_LIGHT_YELLOW + message.toString().formatted(args));
    }

    public void error(Object message, Object... args) {
        System.out.println(AnsiColors.ANSI_LIGHT_WHITE + "[" + name + "/" + AnsiColors.ANSI_LIGHT_RED + "ERROR" + AnsiColors.ANSI_LIGHT_WHITE + "] " + AnsiColors.ANSI_LIGHT_RED + message.toString().formatted(args));
    }

    public void debug(Object message, Object... args) {
        System.out.println(AnsiColors.ANSI_LIGHT_WHITE + "[" + name + "/" + AnsiColors.ANSI_LIGHT_PURPLE + "DEBUG" + AnsiColors.ANSI_LIGHT_WHITE + "] " + message.toString().formatted(args));
    }

    public void config(Object message, Object... args) {
        System.out.println(AnsiColors.ANSI_LIGHT_WHITE + "[" + name + "/" + AnsiColors.ANSI_DARK_GREEN + "CONFIG" + AnsiColors.ANSI_LIGHT_WHITE + "] " + message.toString().formatted(args));
    }
}