package com.jacopo.danielino;

import com.jacopo.danielino.commands.DeleteHotbar;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("§4DIO BASTARDO MERDOSO");

        Bukkit.broadcastMessage("PUCCIA INDIANO");

        // Load commands

        this.getCommand("puccia").setExecutor(new DeleteHotbar());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("§2MADONNA MAIALA");

        Bukkit.broadcastMessage("BRANDO MORTO");
    }
}
