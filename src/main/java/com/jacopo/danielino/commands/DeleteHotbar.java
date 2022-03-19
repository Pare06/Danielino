package com.jacopo.danielino.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class DeleteHotbar implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().info("sei un disabile di merda dio porco");
        }

        Player puccia = Bukkit.getPlayer(args[0]);

        if (puccia == null) {
            sender.sendMessage("hai sbagliato nome, mongoloide");
            return false;
        }

        if (args[1].equals("hotbar")) {
            ArrayList<ItemStack> inv = new ArrayList<>();
            for (ItemStack item : puccia.getInventory()) {
                inv.add(item);
            }

            for (int i = 0; i < 36; i++) {
                puccia.getInventory().setItem(i, new ItemStack(Material.AIR));
            }

            try {
                TimeUnit.SECONDS.sleep(Long.parseLong(args[2]));
            } catch (Exception ex) {
                sender.sendMessage("DIO MAIALE");
            }

            sender.sendMessage("dio maiale");
            for (int i = 0; i < 36; i++) {
                puccia.getInventory().setItem(i, inv.get(i));
            }
        }
        return true;
    }

}
