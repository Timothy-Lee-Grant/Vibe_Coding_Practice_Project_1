package com.forest;

import java.util.HashMap;
import java.util.Map;

public class World {
    private Map<String, Location> locations;
    private Player player;

    public World(Player player) {
        this.player = player;
        this.locations = new HashMap<>();
        initializeLocations();
    }

    private void initializeLocations() {
        // Starting location
        Location clearing = new Location(
            "Forest Clearing",
            "You stand in a peaceful clearing surrounded by tall trees. Sunlight filters through the canopy.\n" +
            "Mushrooms dot the grass around you. You see paths leading north, east, and west.",
            0, 0
        );
        clearing.addItem("mushroom");
        clearing.addItem("stick");
        clearing.addNPC("Wise Owl");
        locations.put("0,0", clearing);

        // North location
        Location darkWoods = new Location(
            "Dark Woods",
            "The forest grows darker here. Twisted branches hang low, and the air feels cold.\n" +
            "You hear the faint sound of running water to the east.",
            0, 1
        );
        darkWoods.addItem("ancient_scroll");
        darkWoods.addNPC("Mysterious Stranger");
        locations.put("0,1", darkWoods);

        // East location
        Location stream = new Location(
            "Crystal Stream",
            "A beautiful stream flows through the forest. The water is crystal clear and cold.\n" +
            "You feel refreshed just looking at it.",
            1, 0
        );
        stream.addItem("healing_herb");
        stream.addItem("water_stone");
        locations.put("1,0", stream);

        // West location
        Location ruins = new Location(
            "Ancient Ruins",
            "Crumbling stone structures peek through the overgrown vegetation.\n" +
            "This place feels ancient and full of secrets.",
            -1, 0
        );
        ruins.addItem("golden_key");
        ruins.addItem("old_coin");
        ruins.addNPC("Spirit");
        locations.put("-1,0", ruins);

        // Northeast location
        Location mountainPass = new Location(
            "Mountain Pass",
            "The forest opens up to a narrow mountain pass. Snow-capped peaks are visible in the distance.\n" +
            "The air is thin but invigorating.",
            1, 1
        );
        mountainPass.addItem("rare_gem");
        locations.put("1,1", mountainPass);

        // Northwest location
        Location cave = new Location(
            "Hidden Cave",
            "A hidden cave entrance opens before you. Bats fly overhead, and the ground is damp.\n" +
            "You hear echoes from deep within.",
            -1, 1
        );
        cave.addItem("bat_wing");
        cave.addItem("crystal");
        cave.addNPC("Bat King");
        locations.put("-1,1", cave);
    }

    public Location getLocation(int x, int y) {
        String key = x + "," + y;
        if (locations.containsKey(key)) {
            return locations.get(key);
        }
        // Return a random undiscovered location
        return new Location(
            "Unexplored Area",
            "You stumble upon an area you haven't been to before.\n" +
            "Strange sounds echo through the trees...",
            x, y
        );
    }

    public Location getCurrentLocation() {
        return getLocation(player.getX(), player.getY());
    }

    public void displayMap() {
        System.out.println("\n" + "═".repeat(40));
        System.out.println("🗺️  FOREST MAP");
        System.out.println("═".repeat(40));
        System.out.println("Explored Locations:");
        for (Location loc : locations.values()) {
            String marker = (loc.getX() == player.getX() && loc.getY() == player.getY()) ? "👤" : "📍";
            System.out.println(String.format("%s %s at [%d, %d]", marker, loc.getName(), loc.getX(), loc.getY()));
        }
    }

    public int getTotalLocations() {
        return locations.size();
    }
}
