package me.Ninjoh.AntiPotion;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MainListener implements Listener
{
    @EventHandler(priority=EventPriority.HIGH)
    public void onPlayerInteractEvent(PlayerInteractEvent e)
    {

        if(e.getItem() != null && e.getItem().getType().equals(Material.POTION) && (!(e.getPlayer().hasPermission("antipotion.bypass"))))
        {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.DARK_RED + "You do not have permission to use potions");
        }
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onBlockDispenseEvent(BlockDispenseEvent e)
    {
        if (e.getItem() != null && e.getItem().getType().equals(Material.POTION))
        {
            e.setCancelled(true);
        }
    }
}