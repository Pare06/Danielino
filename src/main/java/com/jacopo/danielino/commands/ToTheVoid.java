package com.jacopo.danielino.commands;

import com.jacopo.danielino.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public final class ToTheVoid implements CommandExecutor {
    @Override
    // Cancella tutti i blocchi sotto {target} e li fa tornare dopo 10 secondi
    // /pucciavoid {target}
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player puccia = Bukkit.getPlayer(args[0]);
        if (puccia == null) {
            sender.sendMessage("hai sbagliato nome, mongoloide");
            return false;
        }
        PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 100, 255);
        puccia.addPotionEffect(effect);

        int x = puccia.getLocation().getBlockX();
        int z = puccia.getLocation().getBlockZ();
        Location l = puccia.getLocation().clone();
        ArrayList<Material> materials = new ArrayList<>();
        for (int i = 0; i < puccia.getLocation().getBlockY() + 1; i++) {
            Location loc = new Location(
                    puccia.getWorld(),
                    x,
                    i,
                    z
            );
            materials.add(loc.getBlock().getType());
            loc.getBlock().setType(Material.AIR);
        }
        puccia.setVelocity(new Vector(0, 0, 0));
        puccia.teleport(l.subtract(0, 2, 0));
        puccia.setGameMode(GameMode.ADVENTURE);

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Main.plugin, () -> {
            for (int i = 0; i < materials.size(); i++) {
                Location loc = new Location(
                        puccia.getWorld(),
                        x,
                        i,
                        z
                );
                loc.getBlock().setType(materials.get(i));
            }
            puccia.setGameMode(GameMode.SURVIVAL);
        }, 5 * 20);

        return true;
    }
}