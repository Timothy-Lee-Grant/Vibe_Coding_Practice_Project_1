package com.forest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testEmptyInventory() {
        assertTrue(inventory.getItems().isEmpty());
    }

    @Test
    public void testAddItem() {
        inventory.addItem("sword");
        assertTrue(inventory.hasItem("sword"));
        assertEquals(1, inventory.getItemCount("sword"));
    }

    @Test
    public void testAddMultipleSameItems() {
        inventory.addItem("coin");
        inventory.addItem("coin");
        inventory.addItem("coin");
        assertTrue(inventory.hasItem("coin"));
        assertEquals(3, inventory.getItemCount("coin"));
    }

    @Test
    public void testRemoveItem() {
        inventory.addItem("potion");
        inventory.addItem("potion");
        inventory.removeItem("potion");
        assertEquals(1, inventory.getItemCount("potion"));
        inventory.removeItem("potion");
        assertFalse(inventory.hasItem("potion"));
    }

    @Test
    public void testRemoveNonExistentItem() {
        inventory.removeItem("nonexistent");
        assertFalse(inventory.hasItem("nonexistent"));
    }

    @Test
    public void testClearInventory() {
        inventory.addItem("item1");
        inventory.addItem("item2");
        inventory.addItem("item3");
        inventory.clear();
        assertTrue(inventory.getItems().isEmpty());
    }

    @Test
    public void testInventoryToString() {
        inventory.addItem("sword");
        inventory.addItem("shield");
        String result = inventory.toString();
        assertTrue(result.contains("sword") || result.contains("shield"));
    }

    @Test
    public void testEmptyInventoryToString() {
        String result = inventory.toString();
        assertEquals("Inventory: Empty", result);
    }
}
