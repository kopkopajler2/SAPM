package com.popopapi.common.servicebridges.logger;

public interface MinecraftConsoleLogger {
    void info(String message);
    void warn(String message);
    void error(String message);
    void debug(String message);
    void exception(String message, Throwable exception);
}
