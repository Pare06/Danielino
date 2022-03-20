package com.jacopo.danielino.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class To256 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player puccia = Bukkit.getPlayer(args[0]);
        if (puccia == null) {
            sender.sendMessage("hai sbagliato nome, mongoloide");
            return false;
        }

        puccia.teleport(new Location(
                puccia.getWorld(),
                puccia.getLocation().getBlockX(),
                256,
                puccia.getLocation().getBlockZ()
        ));
        return true;
    }
}
