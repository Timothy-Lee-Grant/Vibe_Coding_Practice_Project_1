package com.forest;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private World world;
    private GameUI ui;
    private boolean running;
    private Random random;

    public Game(String playerName, Scanner scanner) {
        this.player = new Player(playerName);
        this.world = new World(player);
        this.ui = new GameUI(this, scanner);
        this.running = true;
        this.random = new Random();
    }

    public void start() {
        ui.displayWelcome();
        mainLoop();
    }

    private void mainLoop() {
        while (running && player.isAlive()) {
            ui.displayStatus(player);
            ui.displayMainMenu();
            int choice = ui.getChoice();

            switch (choice) {
                case 1:
                    exploreMode();
                    break;
                case 2:
                    ui.displayStatus(player);
                    ui.pause();
                    break;
                case 3:
                    ui.displayInventory(player);
                    ui.pause();
                    break;
                case 4:
                    world.displayMap();
                    ui.pause();
                    break;
                case 5:
                    rest();
                    break;
                case 6:
                    quit();
                    break;
                default:
                    ui.displayMessage("Invalid choice! Try again.");
                    ui.pause();
            }

            // Random chance of losing health to hunger (reduced frequency)
            if (random.nextInt(20) < 1) {
                player.takeDamage(1);
            }
        }

        if (!player.isAlive()) {
            ui.displayGameOver(player);
        }
    }

    private void exploreMode() {
        boolean inExplore = true;
        while (inExplore && player.isAlive()) {
            Location current = world.getCurrentLocation();
            current.displayInfo();
            
            ui.displayExploreMenu();
            int choice = ui.getChoice();

            switch (choice) {
                case 1:
                    moveToLocation(0, 1); // North
                    triggerRandomEvent();
                    break;
                case 2:
                    moveToLocation(0, -1); // South
                    triggerRandomEvent();
                    break;
                case 3:
                    moveToLocation(1, 0); // East
                    triggerRandomEvent();
                    break;
                case 4:
                    moveToLocation(-1, 0); // West
                    triggerRandomEvent();
                    break;
                case 5:
                    exploreCurrentArea();
                    break;
                case 6:
                    gatherItems();
                    break;
                case 7:
                    inExplore = false;
                    break;
                default:
                    ui.displayMessage("Invalid choice!");
            }
        }
    }

    private void moveToLocation(int dx, int dy) {
        player.move(dx, dy);
        Location newLocation = world.getCurrentLocation();
        System.out.println("\n🚶 You move to " + newLocation.getName() + "...");
    }

    private void exploreCurrentArea() {
        Location current = world.getCurrentLocation();
        if (!current.isExplored()) {
            System.out.println("\n🔍 You explore the area thoroughly...");
            current.setExplored(true);
            Encounter.randomEvent(player);
        } else {
            System.out.println("\n🔍 You've already explored this area thoroughly.");
        }
        ui.pause();
    }

    private void gatherItems() {
        Location current = world.getCurrentLocation();
        if (current.getAvailableItems().isEmpty()) {
            System.out.println("\n🎒 There are no items to gather here.");
        } else {
            System.out.println("\n🎒 Available items: " + current.getAvailableItems());
            // Simplified item gathering - take first item
            if (!current.getAvailableItems().isEmpty()) {
                String item = current.getAvailableItems().get(0);
                player.addItem(item);
                current.removeItem(item);
                System.out.println("✓ Collected: " + item);
                player.addExperience(10);
            }
        }
        ui.pause();
    }

    private void triggerRandomEvent() {
        if (random.nextInt(10) < 4) { // 40% chance of encounter
            Encounter.randomEvent(player);
            ui.pause();
        }
    }

    private void rest() {
        System.out.println("\n😴 You rest by a safe spot in the forest...");
        player.heal(50);
        System.out.println("You've been restored! Health: " + player.getHealth() + "/" + player.getMaxHealth());
        ui.pause();
    }

    private void quit() {
        System.out.println("\n👋 Thank you for exploring the forest!");
        running = false;
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public boolean isRunning() {
        return running;
    }
}
