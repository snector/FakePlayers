package de.Herbystar.FakePlayers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = null;
        if (sender instanceof Player) {
            p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("fakePlayers")) {
                if (Main.instance.protocolLib == true) {
                    p.sendMessage(Main.instance.internalPrefix + "§aProtocolLib§e§l Mode! §c§lCommands are not supported in this mode!");
                    return true;
                }
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("create")) {
                        if (p.hasPermission("FakePlayers.Commands")) {
                            Main.instance.playerListHandler.addCustomOnlinePlayer(args[1]);
                            p.sendMessage(Main.instance.internalPrefix + "§aPlayer successful created!");
                            return true;
                        }
                    }
                    if (args[0].equalsIgnoreCase("remove")) {
                        if (p.hasPermission("FakePlayers.Commands")) {
                            Main.instance.playerListHandler.removeCustomOnlinePlayer(args[1]);
                            p.sendMessage(Main.instance.internalPrefix + "§aPlayer successful removed!");
                            return true;
                        }
                    }
                }
            }

            if (cmd.getName().equalsIgnoreCase("help")) {
                if (p.hasPermission("FakePlayers.Commands")) {
                    p.sendMessage("§aAvailable commands:");
                    p.sendMessage("§a/fakePlayers create <name> - Creates a fake player with the specified name.");
                    p.sendMessage("§a/fakePlayers remove <name> - Removes the fake player with the specified name.");
                    p.sendMessage("§a/help - Displays help information for FakePlayers plugin.");
                    return true;
                }
            }
        } else {
            if (cmd.getName().equalsIgnoreCase("fakePlayers")) {
                if (Main.instance.protocolLib == true) {
                    Bukkit.getConsoleSender().sendMessage(Main.instance.internalPrefix + "§aProtocolLib§e§l Mode! §c§lCommands are not supported in this mode!");
                    return true;
                }
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("create")) {
                        Main.instance.playerListHandler.addCustomOnlinePlayer(args[1]);
                        Bukkit.getConsoleSender().sendMessage(Main.instance.internalPrefix + "§aPlayer successful created!");
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("remove")) {
                        Main.instance.playerListHandler.removeCustomOnlinePlayer(args[1]);
                        Bukkit.getConsoleSender().sendMessage(Main.instance.internalPrefix + "§aPlayer successful removed!");
                        return true;
                    }
                }
            }

            if (cmd.getName().equalsIgnoreCase("help")) {
                Bukkit.getConsoleSender().sendMessage("§aAvailable commands:");
                Bukkit.getConsoleSender().sendMessage("§a/fakePlayers create <name> - Creates a fake player with the specified name.");
                Bukkit.getConsoleSender().sendMessage("§a/fakePlayers remove <name> - Removes the fake player with the specified name.");
                Bukkit.getConsoleSender().sendMessage("§a/help - Displays help information for FakePlayers plugin.");
                return true;
            }
        }
        return false;
    }
}
