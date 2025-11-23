package com.forest;

import java.util.Scanner;

public class ForestGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║          🌲 FOREST EXPLORER 🌲             ║");
        System.out.println("║                                            ║");
        System.out.println("║     Explore a mysterious forest full of    ║");
        System.out.println("║     adventure, treasures, and mysteries!   ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine().trim();
        
        if (playerName.isEmpty()) {
            playerName = "Adventurer";
        }

        Game game = new Game(playerName, scanner);
        game.start();
    }
}
