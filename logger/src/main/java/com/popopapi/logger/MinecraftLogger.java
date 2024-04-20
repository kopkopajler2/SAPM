package com.popopapi.logger;
import  com.popopapi.common.servicebridges.logger.MinecraftConsoleLogger;
public class MinecraftLogger {
    private static MinecraftConsoleLogger logger;

    public static void setLogger(MinecraftConsoleLogger logger) {
        MinecraftLogger.logger = logger;
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void exception(String message, Throwable exception) {
        logger.exception(message, exception);
    }
}
