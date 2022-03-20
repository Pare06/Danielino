package com.jacopo.danielino.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class DeleteInventory implements CommandExecutor {

    // Cancella l'inventario di {target} e lo fa tornare in args[0] secondi
    // /pucciainv {target} {cooldown}
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player puccia = Bukkit.getPlayer(args[0]);
        if (puccia == null) {
            sender.sendMessage("hai sbagliato nome, mongoloide");
            return false;
        }

        // puccia.inv -> inv
        ArrayList<ItemStack> inv = new ArrayList<>();
        for (ItemStack item : puccia.getInventory()) {
            inv.add(item);
        }
        // clear inv
        for (int i = 0; i < 36; i++) {
            puccia.getInventory().setItem(i, new ItemStack(Material.AIR));
        }
        try {
            TimeUnit.SECONDS.sleep(Long.parseLong(args[1]));
        } catch (Exception ex) {
            sender.sendMessage("SEI UN MONGOLO DIO MAIALE");
            return false;
        }
        // restore inv
        for (int i = 0; i < 36; i++) {
            puccia.getInventory().setItem(i, inv.get(i));
        }
        return true;
    }

}
