package ru.werckut.custominventoryapi.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.werckut.custominventoryapi.util.InventoryRegister;
import ru.werckut.custominventoryapi.util.SlotManager;

import java.util.*;
import java.util.stream.Collectors;

public class CustomInventoryListener implements Listener {
    private final Set<String> players = new HashSet<>();
    private final Set<String> inventoriesTitles;
    private final Plugin plugin;

    public CustomInventoryListener(Plugin plugin) {
        this.inventoriesTitles = InventoryRegister.getAllTitles();
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (players.contains(e.getWhoClicked().getName())) {
            SlotManager sm = InventoryRegister.get(e.getView().getTitle()).getSlotManager();

            if (!sm.allow(e.getRawSlot()) || e.getClick().equals(ClickType.SHIFT_LEFT)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        if (players.contains(e.getWhoClicked().getName())) {
            SlotManager sm = InventoryRegister.get(e.getView().getTitle()).getSlotManager();

            Set<Integer> filledSlots = e.getNewItems().keySet();
            Set<Integer> activeSlots = filledSlots.stream().filter(sm::allow).collect(Collectors.toSet());

            int activeSlotsCount = activeSlots.size();
            if (activeSlotsCount != 0) {
                if (filledSlots.size() == 1) return;

                int cursor;
                int itemGift;
                boolean isEven = e.getType().equals(DragType.EVEN);
                if (!isEven) {
                    cursor = e.getOldCursor().getAmount() - activeSlotsCount;
                    itemGift = 1;
                } else {
                    cursor = e.getOldCursor().getAmount() % activeSlotsCount;
                    itemGift = e.getOldCursor().getAmount() / activeSlotsCount;
                }

                for (Integer slot : activeSlots) {
                    var item = e.getView().getItem(slot);
                    if (item != null) {
                        item.setAmount(item.getAmount() + itemGift);
                    } else {
                        e.getView().setItem(slot, new ItemStack(e.getOldCursor().getType(), itemGift));
                    }
                }

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        e.getView().setCursor(new ItemStack(e.getOldCursor().getType(), cursor));
                    }
                }.runTask(this.plugin);
            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(InventoryMoveItemEvent e) {
        System.out.println("move item");
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        if (inventoriesTitles.contains(e.getView().getTitle())) {
            players.add(e.getPlayer().getName());
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        players.remove(e.getPlayer().getName());
    }
}
