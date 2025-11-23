package com.forest;

import java.util.Random;

public class Encounter {
    private static final Random random = new Random();

    public static void wildAnimal(Player player) {
        String[] animals = {"Wolf", "Bear", "Deer", "Fox", "Rabbit"};
        String animal = animals[random.nextInt(animals.length)];
        System.out.println("\n⚠️  A wild " + animal + " appears!");

        int damage = random.nextInt(15) + 5;
        System.out.println("The " + animal + " attacks you for " + damage + " damage!");
        player.takeDamage(damage);
        System.out.println("Your health: " + player.getHealth() + "/" + player.getMaxHealth());
    }

    public static void findTreasure(Player player) {
        String[] treasures = {"Ancient Coin", "Shiny Gem", "Golden Amulet", "Silver Ring"};
        String treasure = treasures[random.nextInt(treasures.length)];
        System.out.println("\n💎 You found a " + treasure + "!");
        player.addItem(treasure);
        player.addExperience(50);
        System.out.println("Gained 50 XP!");
    }

    public static void meetNPC(Player player, String npcName) {
        System.out.println("\n👥 You meet " + npcName + "!");
        
        switch (npcName) {
            case "Wise Owl":
                System.out.println("\"Welcome to the forest, traveler! Be careful of the creatures here.\"");
                player.heal(20);
                System.out.println("The Owl heals you for 20 HP!");
                break;
            case "Mysterious Stranger":
                System.out.println("\"You shouldn't be here... Take this and go.\"");
                player.addItem("mysterious_map");
                player.addExperience(75);
                System.out.println("Gained mysterious_map and 75 XP!");
                break;
            case "Spirit":
                System.out.println("\"I guard these ruins... Prove your worth!\"");
                if (random.nextBoolean()) {
                    System.out.println("The Spirit challenges you!");
                    wildAnimal(player);
                } else {
                    System.out.println("The Spirit is satisfied with your presence.");
                    player.addExperience(100);
                    System.out.println("Gained 100 XP!");
                }
                break;
            case "Bat King":
                System.out.println("\"Screeeech! Welcome to our domain!\"");
                player.addItem("bat_fang");
                player.addExperience(60);
                System.out.println("Gained bat_fang and 60 XP!");
                break;
            default:
                System.out.println("\"Hello there, adventurer!\"");
        }
    }

    public static void randomEvent(Player player) {
        int eventType = random.nextInt(3);
        switch (eventType) {
            case 0:
                wildAnimal(player);
                break;
            case 1:
                findTreasure(player);
                break;
            case 2:
                System.out.println("\n🌿 You find some healing herbs!");
                player.heal(15);
                System.out.println("Healed 15 HP!");
                break;
        }
    }
}
