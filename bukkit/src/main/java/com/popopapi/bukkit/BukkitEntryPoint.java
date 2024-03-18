package com.popopapi.bukkit;

import com.popopapi.bukkit.init.BukkitInit;
import commandhandler.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public final class BukkitEntryPoint extends JavaPlugin  {

    @Override
    public void onEnable() {

        // Anonymous implementation of "/check" root command.
        CommandBase<BukkitEntryPoint> checkCommand = new CommandBase<BukkitEntryPoint>(this) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                sender.sendMessage("The root command does nothing! Use a sub command.");
                return false;
            }
        };

        CheckThisCommand checkThisCommand = new CheckThisCommand(this);
        // Register "/check this" with the root "/check" command.
        checkCommand.registerSubCommand("this", checkThisCommand);

        // Register "/check this out" with the sub command "/check this".
        checkThisCommand.registerSubCommand("out", new CheckThisOutCommand());

        // Register "/check" command executor with Bukkit.
        getCommand("check").setExecutor(checkCommand);
    }

    private static class CheckThisCommand extends CommandBase<BukkitEntryPoint> {

        public CheckThisCommand(BukkitEntryPoint plugin) {
            super(plugin);
        }

        @Override
        public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
            sender.sendMessage("I'm the first sub command. Fuck year!");
            return true;
        }
    }

    private static class CheckThisOutCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            sender.sendMessage("I'm a leaf, get it?");
            // returning false will cause the root commands description to be sent to the sender.
            return false;
        }
    }
}
