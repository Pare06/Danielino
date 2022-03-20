package com.jacopo.danielino.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CobWebSlow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player puccia = Bukkit.getPlayer(args[0]);
        Location loc = puccia.getLocation();
        loc.getBlock().setType(Material.COBWEB);
        loc = loc.add(0, 1, 0);
        loc.getBlock().setType(Material.COBWEB);
        puccia.addPotionEffect(new PotionEffect(
                PotionEffectType.SLOW,
                60,
                255
        ));
        return true;
    }
}
