package me.Ninjoh.AntiPotion;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        getServer().getPluginManager().registerEvents(new me.Ninjoh.AntiPotion.MainListener(), this);
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }

}