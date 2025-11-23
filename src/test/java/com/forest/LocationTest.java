package com.forest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {
    private Location location;

    @BeforeEach
    public void setUp() {
        location = new Location("Forest Clearing", "A peaceful clearing", 0, 0);
    }

    @Test
    public void testLocationCreation() {
        assertEquals("Forest Clearing", location.getName());
        assertEquals("A peaceful clearing", location.getDescription());
        assertEquals(0, location.getX());
        assertEquals(0, location.getY());
        assertFalse(location.isExplored());
    }

    @Test
    public void testAddItem() {
        location.addItem("mushroom");
        location.addItem("stick");
        assertTrue(location.getAvailableItems().contains("mushroom"));
        assertTrue(location.getAvailableItems().contains("stick"));
    }

    @Test
    public void testRemoveItem() {
        location.addItem("mushroom");
        location.removeItem("mushroom");
        assertFalse(location.getAvailableItems().contains("mushroom"));
    }

    @Test
    public void testAddNPC() {
        location.addNPC("Wise Owl");
        location.addNPC("Mysterious Stranger");
        assertTrue(location.getNPCs().contains("Wise Owl"));
        assertTrue(location.getNPCs().contains("Mysterious Stranger"));
    }

    @Test
    public void testSetExplored() {
        assertFalse(location.isExplored());
        location.setExplored(true);
        assertTrue(location.isExplored());
    }

    @Test
    public void testGetAvailableItems() {
        location.addItem("item1");
        location.addItem("item2");
        assertEquals(2, location.getAvailableItems().size());
    }

    @Test
    public void testGetNPCs() {
        location.addNPC("NPC1");
        location.addNPC("NPC2");
        location.addNPC("NPC3");
        assertEquals(3, location.getNPCs().size());
    }
}
