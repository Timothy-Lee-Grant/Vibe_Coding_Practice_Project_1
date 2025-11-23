package com.forest;

public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int x;
    private int y;
    private int experience;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.x = 0;
        this.y = 0;
        this.experience = 0;
        this.inventory = new Inventory();
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public void heal(int amount) {
        this.health = Math.min(maxHealth, this.health + amount);
    }

    public void addExperience(int xp) {
        this.experience += xp;
    }

    public void addItem(String item) {
        this.inventory.addItem(item);
    }

    public void removeItem(String item) {
        this.inventory.removeItem(item);
    }

    public boolean hasItem(String item) {
        return this.inventory.hasItem(item);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getExperience() {
        return experience;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return String.format("%s (HP: %d/%d, XP: %d, Position: [%d, %d])", 
            name, health, maxHealth, experience, x, y);
    }
}
