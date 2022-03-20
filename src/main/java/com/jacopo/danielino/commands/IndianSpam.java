package com.jacopo.danielino.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class IndianSpam implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player puccia = Bukkit.getPlayer(args[0]);
        if (puccia == null) {
            sender.sendMessage("hai sbagliato nome, mongoloide");
            return false;
        }

        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]);
        }
        for (int i = 0; i < 20; i++) {
            puccia.sendMessage(message.toString());
        }
        return true;
    }
}
