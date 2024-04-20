package com.popopapi.bukkit.implementations;
import org.bukkit.Bukkit;
import com.popopapi.common.servicebridges.logger.MinecraftConsoleLogger;
public class BukkitConsoleLogger implements MinecraftConsoleLogger {
    @Override
    public void info(String message) {
        Bukkit.getLogger().info(message);
    }

    @Override
    public void warn(String message) {
        Bukkit.getLogger().warning(message);
    }

    @Override
    public void error(String message) {
        Bukkit.getLogger().severe(message);
    }

    @Override
    public void debug(String message) {
        Bukkit.getLogger().fine(message);
    }

    @Override
    public void exception(String message, Throwable exception) {
        Bukkit.getLogger().severe(message);
        exception.printStackTrace();
    }
}
