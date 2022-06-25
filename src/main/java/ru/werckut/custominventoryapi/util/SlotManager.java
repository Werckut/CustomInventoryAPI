package ru.werckut.custominventoryapi.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SlotManager {
    private Set<Integer> slots;
    private final int size;

    public SlotManager(int size) {
        this.size = size;
    }

    public boolean allow(int slot) {
        return this.slots.contains(slot) || slot >= size;
    }

    public boolean allow(Integer... slots) {
        return this.slots.containsAll(List.of(slots)) || Arrays.stream(slots).allMatch(i -> i >= size);
    }

    public void setSlots(Integer... slots) {
        this.slots = Set.of(slots);
    }

    public void setSlots(Set<Integer> slots) {
        this.slots = slots;
    }

    public Set<Integer> getSlots() {
        return this.slots;
    }
}
