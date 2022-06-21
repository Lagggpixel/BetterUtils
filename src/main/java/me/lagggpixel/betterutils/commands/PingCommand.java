package me.lagggpixel.betterutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {

        if (commandSender instanceof Player sender) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Your ping is: " + sender.getPing());
                return true;
            }

            if (args.length == 1) {

                Player player = Bukkit.getPlayerExact(args[0]);

                if (player == null) {
                    sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "That player is not online");
                    return true;
                }

                if (player == sender) {
                    sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Your ping is: " + sender.getPing());
                    return true;
                }

                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + args[0] + "'s ping is: " + player.getPing());
                return true;
            }

            sender.sendMessage(ChatColor.RED + "Invalid usage");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Player only command");
        }

        return true;
    }
}
