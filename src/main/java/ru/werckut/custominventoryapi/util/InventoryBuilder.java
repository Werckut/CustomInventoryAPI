package ru.werckut.custominventoryapi.util;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import ru.werckut.custominventoryapi.inventory.CustomInventory;

public interface InventoryBuilder {
    InventoryBuilder setSlots(Integer... slots);
    InventoryBuilder setTitle(String title);
    InventoryBuilder setSlotManager(Class<? extends SlotManager> manager);
    InventoryBuilder setOwner(InventoryHolder owner);
    InventoryBuilder setRows(int rows);
    InventoryBuilder setType(InventoryType type);
    CustomInventory build();
}
