package ru.werckut.custominventoryapi;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.werckut.custominventoryapi.inventory.CustomInventory;
import ru.werckut.custominventoryapi.listener.BlockListenerDEL;
import ru.werckut.custominventoryapi.listener.CustomInventoryListener;
import ru.werckut.custominventoryapi.util.CustomInventoryBuilder;
import ru.werckut.custominventoryapi.util.InventoryRegister;
import ru.werckut.custominventoryapi.util.SlotManager;

public final class CustomInventoryAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        InventoryRegister.register(new CustomInventoryBuilder()
                .setRows(3)
                .setTitle(ChatColor.WHITE + "\uF808\uE001\uF828")
                .setSlots(10, 13)
                .setSlotManager(SlotManager.class)
                .build());

        InventoryRegister.register(new CustomInventoryBuilder()
                .setRows(6)
                .setTitle(ChatColor.WHITE + "\uF808\uE002\uF828")
                .setSlots(10)
                .setSlotManager(SlotManager.class)
                .build());

        getServer().getPluginManager().registerEvents(new CustomInventoryListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockListenerDEL(), this);
    }
}
