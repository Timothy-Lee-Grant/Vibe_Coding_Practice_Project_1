package com.forest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("TestHero");
    }

    @Test
    public void testPlayerCreation() {
        assertEquals("TestHero", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(100, player.getMaxHealth());
        assertEquals(0, player.getExperience());
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
        assertTrue(player.isAlive());
    }

    @Test
    public void testPlayerMovement() {
        player.move(1, 2);
        assertEquals(1, player.getX());
        assertEquals(2, player.getY());
    }

    @Test
    public void testTakeDamage() {
        player.takeDamage(30);
        assertEquals(70, player.getHealth());
        assertTrue(player.isAlive());
    }

    @Test
    public void testDamageDeathThreshold() {
        player.takeDamage(100);
        assertEquals(0, player.getHealth());
        assertFalse(player.isAlive());
    }

    @Test
    public void testHeal() {
        player.takeDamage(50);
        player.heal(20);
        assertEquals(70, player.getHealth());
    }

    @Test
    public void testHealMaxHealth() {
        player.heal(100);
        assertEquals(100, player.getHealth());
    }

    @Test
    public void testAddExperience() {
        player.addExperience(50);
        assertEquals(50, player.getExperience());
        player.addExperience(50);
        assertEquals(100, player.getExperience());
    }

    @Test
    public void testAddItem() {
        player.addItem("sword");
        assertTrue(player.hasItem("sword"));
    }

    @Test
    public void testRemoveItem() {
        player.addItem("sword");
        assertTrue(player.hasItem("sword"));
        player.removeItem("sword");
        assertFalse(player.hasItem("sword"));
    }

    @Test
    public void testPlayerToString() {
        String result = player.toString();
        assertTrue(result.contains("TestHero"));
        assertTrue(result.contains("HP: 100/100"));
    }
}
