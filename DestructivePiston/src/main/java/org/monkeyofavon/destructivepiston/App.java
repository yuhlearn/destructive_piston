package org.monkeyofavon.destructivepiston;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new BlockPhysicsListener(), this);
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }
}