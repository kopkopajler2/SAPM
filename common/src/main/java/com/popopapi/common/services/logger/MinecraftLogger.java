package com.popopapi.common.services.logger;
public class MinecraftLogger {
    private static MinecraftConsoleLogger logger;

    public static void setLogger(MinecraftConsoleLogger logger) {
        MinecraftLogger.logger = logger;
    }

    public static void info(String message) {
        info(message, false);
    }

    public static void info(String message, boolean logToServerConsole) {
        logger.info(message, logToServerConsole);
        logToFile(message);
    }

    public static void warn(String message) {
        warn(message, false);
    }

    public static void warn(String message, boolean logToServerConsole) {
        logger.warn(message, logToServerConsole);
        logToFile(message);
    }

    public static void error(String message) {
        error(message, false);
    }

    public static void error(String message, boolean logToServerConsole) {
        logger.error(message, logToServerConsole);
        logToFile(message);
    }

    public static void debug(String message) {
        debug(message, false);
    }

    public static void debug(String message, boolean logToServerConsole) {
        logger.debug(message, logToServerConsole);
        logToFile(message);
    }

    public static void exception(String message, Throwable exception) {
        exception(message, exception, false);
    }

    public static void exception(String message, Throwable exception, boolean logToServerConsole) {
        logger.exception(message, exception, logToServerConsole);
        logToFile(message + ": " + exception.getMessage());
    }

    public static void logToFile(String message) {
        logger.logToFile(message);
    }
}