package ru.werckut.custominventoryapi.listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import ru.werckut.custominventoryapi.util.InventoryRegister;

public class BlockListenerDEL implements Listener {
    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getClickedBlock().getLocation().toVector().equals(new Vector(-10.0,-63.0,11.0))) {
                e.setCancelled(true);
                e.getPlayer().openInventory(InventoryRegister.get(ChatColor.WHITE + "\uF808\uE001\uF828").getInventory());
            }
            if (e.getClickedBlock().getLocation().toVector().equals(new Vector(-6, -63, 11))) {
                e.setCancelled(true);
                e.getPlayer().openInventory(InventoryRegister.get(ChatColor.WHITE + "\uF808\uE002\uF828").getInventory());
            }
        }
    }
}
