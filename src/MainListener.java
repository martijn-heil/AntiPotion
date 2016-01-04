package me.Ninjoh.AntiPotion;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.Potion;

public class MainListener implements Listener
{
    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e)
    {
            if(e.getItem().getType().equals(Material.POTION))
            {
                Potion potion = Potion.fromItemStack(e.getItem());

                if(potion.getLevel() != 0)
                {
                    e.setCancelled(true);

                    e.getPlayer().sendMessage(ChatColor.DARK_RED + "You do not have permission to drink potions");
                }
            }
    }


    @EventHandler
    public void onBlockDispenseEvent(BlockDispenseEvent e)
    {
            if(e.getItem().getType().equals(Material.POTION))
            {
                Potion potion = Potion.fromItemStack(e.getItem());

                if(potion.getLevel() != 0)
                {
                    e.setCancelled(true);
                }
            }
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e)
    {

            if(e.getItem() != null && e.getItem().getType().equals(Material.POTION) && (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))
            {
                Potion potion = Potion.fromItemStack(e.getItem());

                if(potion.getLevel() != 0 && potion.isSplash())
                {
                    e.setCancelled(true);

                    e.getPlayer().sendMessage(ChatColor.DARK_RED + "You do not have permission to throw potions");
                }
            }
    }
}