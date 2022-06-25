package ru.werckut.custominventoryapi.util;

import ru.werckut.custominventoryapi.inventory.CustomInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class InventoryRegister {
    private static final Map<String, CustomInventory> registeredInventories = new HashMap<>();

    private InventoryRegister() {

    }

    public static void register(CustomInventory inventory) {
        registeredInventories.put(inventory.getTitle(), inventory);
    }

    public static CustomInventory get(String title) {
        return registeredInventories.get(title);
    }

    public static Set<String> getAllTitles() {
        return registeredInventories.keySet();
    }
}
