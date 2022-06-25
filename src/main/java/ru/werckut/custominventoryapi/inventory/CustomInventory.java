package ru.werckut.custominventoryapi.inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import ru.werckut.custominventoryapi.util.SlotManager;

public final class CustomInventory {
    private final Inventory inventory;
    private final String title;
    private SlotManager slotManager;

    public CustomInventory(InventoryHolder owner, String title, int size, SlotManager slotManager) {
        this.inventory = Bukkit.createInventory(owner, size, title);
        this.title = title;
        this.slotManager = slotManager;
    }

    public CustomInventory(String title, int size, SlotManager slotManager) {
        this(null, title, size, slotManager);
    }

    public CustomInventory(InventoryHolder owner, String title, InventoryType type, SlotManager slotManager) {
        this.inventory = Bukkit.createInventory(owner, type, title);
        this.title = title;
        this.slotManager = slotManager;
    }

    public CustomInventory(String title, InventoryType type, SlotManager slotManager) {
        this(null, title, type, slotManager);
    }



    public String getTitle() {
        return title;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public SlotManager getSlotManager() {
        return slotManager;
    }

    public void setSlotManager(SlotManager slotManager) {
        this.slotManager = slotManager;
    }


    @Deprecated
    public int getSize() {
        return inventory.getSize();
    }
}
