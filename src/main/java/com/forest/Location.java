package com.forest;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private String description;
    private int x;
    private int y;
    private List<String> availableItems;
    private List<String> npcs;
    private boolean explored;

    public Location(String name, String description, int x, int y) {
        this.name = name;
        this.description = description;
        this.x = x;
        this.y = y;
        this.availableItems = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.explored = false;
    }

    public void addItem(String item) {
        availableItems.add(item);
    }

    public void removeItem(String item) {
        availableItems.remove(item);
    }

    public void addNPC(String npc) {
        npcs.add(npc);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<String> getAvailableItems() {
        return new ArrayList<>(availableItems);
    }

    public List<String> getNPCs() {
        return new ArrayList<>(npcs);
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    public void displayInfo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📍 " + name);
        System.out.println("=".repeat(50));
        System.out.println(description);
        if (!availableItems.isEmpty()) {
            System.out.println("\n🎒 Items here: " + availableItems);
        }
        if (!npcs.isEmpty()) {
            System.out.println("👥 NPCs: " + npcs);
        }
    }
}
