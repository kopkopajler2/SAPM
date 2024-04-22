package com.popopapi.bukkit.implementations;
import org.bukkit.Bukkit;
import com.popopapi.common.services.logger.MinecraftConsoleLogger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class BukkitConsoleLogger implements MinecraftConsoleLogger {
    // ...

    @Override
    public void info(String message, boolean logToServerConsole) {
        if (logToServerConsole) {
            Bukkit.getLogger().info(message);
        }
    }

    @Override
    public void warn(String message, boolean logToServerConsole) {
        if (logToServerConsole) {
            Bukkit.getLogger().warning(message);
        }
    }

    @Override
    public void error(String message, boolean logToServerConsole) {
        if (logToServerConsole) {
            Bukkit.getLogger().severe(message);
        }
    }

    @Override
    public void debug(String message, boolean logToServerConsole) {
        if (logToServerConsole) {
            Bukkit.getLogger().fine(message);
        }
    }

    @Override
    public void exception(String message, Throwable exception, boolean logToServerConsole) {
        if (logToServerConsole) {
            Bukkit.getLogger().severe(message);
            exception.printStackTrace();
        }
    }

    @Override
    public void logToFile(String message) {
        File logsFolder = new File("../common/src/main/resources/logs");
        if (!logsFolder.exists()) {
            logsFolder.mkdirs();
        }

        File logFile = new File(logsFolder, "server.log");
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            // Handle the exception appropriately (e.g., print an error message)
            e.printStackTrace();
        }
    }
}
