package com.forest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {
    private Player player;
    private World world;

    @BeforeEach
    public void setUp() {
        player = new Player("Adventurer");
        world = new World(player);
    }

    @Test
    public void testWorldCreation() {
        assertNotNull(world);
        assertEquals(6, world.getTotalLocations());
    }

    @Test
    public void testGetCurrentLocation() {
        Location current = world.getCurrentLocation();
        assertNotNull(current);
        assertEquals("Forest Clearing", current.getName());
    }

    @Test
    public void testGetLocationByCoordinates() {
        Location darkWoods = world.getLocation(0, 1);
        assertNotNull(darkWoods);
        assertEquals("Dark Woods", darkWoods.getName());
    }

    @Test
    public void testGetUnexploredLocation() {
        Location unexplored = world.getLocation(100, 100);
        assertNotNull(unexplored);
        assertEquals("Unexplored Area", unexplored.getName());
    }

    @Test
    public void testPlayerMovement() {
        player.move(1, 0);
        Location stream = world.getCurrentLocation();
        assertEquals("Crystal Stream", stream.getName());
    }

    @Test
    public void testAllKnownLocations() {
        assertNotNull(world.getLocation(0, 0));  // Forest Clearing
        assertNotNull(world.getLocation(0, 1));  // Dark Woods
        assertNotNull(world.getLocation(1, 0));  // Crystal Stream
        assertNotNull(world.getLocation(-1, 0)); // Ancient Ruins
        assertNotNull(world.getLocation(1, 1));  // Mountain Pass
        assertNotNull(world.getLocation(-1, 1)); // Hidden Cave
    }

    @Test
    public void testClearingHasItems() {
        Location clearing = world.getLocation(0, 0);
        assertFalse(clearing.getAvailableItems().isEmpty());
    }

    @Test
    public void testClearingHasNPCs() {
        Location clearing = world.getLocation(0, 0);
        assertFalse(clearing.getNPCs().isEmpty());
    }
}
