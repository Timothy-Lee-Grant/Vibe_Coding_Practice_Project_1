package com.forest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(String item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    public void removeItem(String item) {
        if (items.containsKey(item)) {
            int count = items.get(item);
            if (count > 1) {
                items.put(item, count - 1);
            } else {
                items.remove(item);
            }
        }
    }

    public boolean hasItem(String item) {
        return items.containsKey(item) && items.get(item) > 0;
    }

    public int getItemCount(String item) {
        return items.getOrDefault(item, 0);
    }

    public List<String> getItems() {
        return new ArrayList<>(items.keySet());
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Inventory: Empty";
        }
        StringBuilder sb = new StringBuilder("Inventory: ");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey()).append(" (").append(entry.getValue()).append("), ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
