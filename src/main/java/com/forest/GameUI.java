package com.forest;

import java.util.Scanner;

public class GameUI {
    private Scanner scanner;
    private Game game;

    public GameUI(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    public void displayWelcome() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║          🌲 FOREST EXPLORER 🌲             ║");
        System.out.println("║                                            ║");
        System.out.println("║     Explore a mysterious forest full of    ║");
        System.out.println("║     adventure, treasures, and mysteries!   ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }

    public String getPlayerName() {
        System.out.print("Enter your character name: ");
        return scanner.nextLine().trim();
    }

    public void displayMainMenu() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("MAIN MENU");
        System.out.println("═".repeat(50));
        System.out.println("1. Explore");
        System.out.println("2. View Status");
        System.out.println("3. View Inventory");
        System.out.println("4. View Map");
        System.out.println("5. Rest (Restore HP)");
        System.out.println("6. Quit Game");
        System.out.print("\nChoice (1-6): ");
    }

    public void displayExploreMenu() {
        Location current = game.getWorld().getCurrentLocation();
        System.out.println("\n" + "═".repeat(50));
        System.out.println("EXPLORE MENU");
        System.out.println("═".repeat(50));
        System.out.println("1. Move North");
        System.out.println("2. Move South");
        System.out.println("3. Move East");
        System.out.println("4. Move West");
        System.out.println("5. Explore Area");
        System.out.println("6. Gather Items");
        System.out.println("7. Return to Main Menu");
        System.out.print("\nChoice (1-7): ");
    }

    public void displayStatus(Player player) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("CHARACTER STATUS");
        System.out.println("═".repeat(50));
        System.out.println("Name: " + player.getName());
        System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());
        System.out.println("Experience: " + player.getExperience());
        System.out.println("Position: [" + player.getX() + ", " + player.getY() + "]");
        System.out.println("Current Location: " + game.getWorld().getCurrentLocation().getName());
        System.out.println("═".repeat(50));
    }

    public void displayInventory(Player player) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("INVENTORY");
        System.out.println("═".repeat(50));
        if (player.getInventory().getItems().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (String item : player.getInventory().getItems()) {
                int count = player.getInventory().getItemCount(item);
                System.out.println("• " + item + " (x" + count + ")");
            }
        }
        System.out.println("═".repeat(50));
    }

    public void displayGameOver(Player player) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║          💀 GAME OVER 💀                   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        System.out.println("You fell in the forest...");
        System.out.println("Final Stats:");
        System.out.println("- Name: " + player.getName());
        System.out.println("- Experience Earned: " + player.getExperience());
        System.out.println("- Items Found: " + player.getInventory().getItems().size());
        System.out.println("\nThanks for playing Forest Explorer!");
    }

    public void displayVictory(Player player) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║       ⭐ CONGRATULATIONS! ⭐              ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        System.out.println("You have successfully explored the forest!");
        System.out.println("Final Stats:");
        System.out.println("- Name: " + player.getName());
        System.out.println("- Experience Earned: " + player.getExperience());
        System.out.println("- Items Found: " + player.getInventory().getItems().size());
        System.out.println("- Locations Explored: " + game.getWorld().getTotalLocations());
    }

    public int getChoice() {
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return -1; // Empty input is invalid
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void pause() {
        System.out.print("\nPress Enter to continue...");
        try {
            scanner.nextLine();
        } catch (Exception e) {
            // Ignore if no input available
        }
    }

    public void close() {
        scanner.close();
    }
}
