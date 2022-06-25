package ru.werckut.custominventoryapi.util;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import ru.werckut.custominventoryapi.inventory.CustomInventory;

import java.lang.reflect.InvocationTargetException;

public final class CustomInventoryBuilder implements InventoryBuilder {
    private InventoryHolder owner;
    private String title;
    private int rows;
    private Integer[] slots;
    private InventoryType type;
    private Class<? extends SlotManager> slotManager;

    @Override
    public InventoryBuilder setSlots(Integer... slots) {
        this.slots = slots;
        return this;
    }

    @Override
    public InventoryBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public InventoryBuilder setSlotManager(Class<? extends SlotManager> manager) {
        this.slotManager = manager;
        return this;
    }

    @Override
    public InventoryBuilder setOwner(InventoryHolder owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public InventoryBuilder setRows(int rows) {
        this.rows = rows;
        return this;
    }

    @Override
    public InventoryBuilder setType(InventoryType type) {
        this.type = type;
        return this;
    }

    @Override
    public CustomInventory build() {
        SlotManager manager = null;
        try {
            manager = slotManager.getConstructor(int.class)
                    .newInstance(rows*9);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        manager.setSlots(slots);
        if (type != null) {
            return new CustomInventory(owner, title, type, manager);
        } else {
            return new CustomInventory(owner, title, rows*9, manager);
        }
    }
}
