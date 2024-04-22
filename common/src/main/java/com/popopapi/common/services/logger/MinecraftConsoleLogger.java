package com.popopapi.common.services.logger;

public interface MinecraftConsoleLogger {
    void info(String message, boolean logToServerConsole);
    void warn(String message, boolean logToServerConsole);
    void error(String message, boolean logToServerConsole);
    void debug(String message, boolean logToServerConsole);
    void exception(String message, Throwable exception, boolean logToServerConsole);
    void logToFile(String message);
}
