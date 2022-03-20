package com.jacopo.danielino;

import com.jacopo.danielino.commands.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin = null;
    @Override
    public void onEnable() {
        //Bukkit.getLogger().info("§4DanielinoPuccino loaded"); <- non voglio che mihai lo noti nella console

        plugin = this;
        this.getCommand("pucciainv").setExecutor(new DeleteInventory());
        this.getCommand("pucciavoid").setExecutor(new ToTheVoid());
        this.getCommand("pucciatop").setExecutor(new To256());
        this.getCommand("pucciaslow").setExecutor(new CobWebSlow());
        this.getCommand("pucciaspam").setExecutor(new IndianSpam());
    }

    @Override
    public void onDisable() {
        //Bukkit.getLogger().info("§4DanielinoPuccino unloaded");
        plugin = null;
    }
}
