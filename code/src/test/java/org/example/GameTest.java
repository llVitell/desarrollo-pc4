package org.example;

import org.example.enemies.BasicEnemy;
import org.example.towers.CannonTower;
import org.example.towers.SniperTower;
import org.example.towers.TowerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameTest {
    @Mock
    Map mockMap;
    @Mock
    Game mockGame;
    @Mock
    Wave mockWave;

    @Test
    void testPlaceTower_ValidPosition() {
        when(mockMap.isValidPosition(3, 4)).thenReturn(true);
        mockGame = new Game(mockMap);
        mockGame.placeTower(new CannonTower().createTower(), 3, 4);
        verify(mockMap).placeTower(any(Tower.class), eq(3), eq(4));
        Map map = new Map();
        map.placeTower(new CannonTower().createTower(), 0, 0);
        assertFalse(map.isValidPosition(0, 0));
    }
    @Test
    void testPlaceTower_InvalidPosition() {
        when(mockMap.isValidPosition(3, 4)).thenReturn(false);
        mockGame = new Game(mockMap);
        mockGame.placeTower(new CannonTower().createTower(), 3, 4);
        verify(mockMap, never()).placeTower(any(Tower.class), eq(3), eq(4));
        Map map = new Map();
        map.placeTower(new SniperTower().createTower(), 0, 2);
        assertFalse(map.isValidPosition(0, 2));
    }
    @Test
    void testAttack_EnemyInRange() {
        List<Enemy> enemies = List.of(new BasicEnemy().createEnemy());
        enemies.get(0).setPosition(2, 2);
        Tower tower = new SniperTower().createTower();
        tower.setPosition(2, 1);
        tower.attack(enemies);
        assertEquals(30, enemies.get(0).getHealth());
    }
    @Test
    void testAttack_EnemyOutOfRange() {
        List<Enemy> enemies = List.of(new BasicEnemy().createEnemy());
        enemies.get(0).setPosition(5, 5);
        Tower tower = new CannonTower().createTower();
        tower.setPosition(2, 1);
        tower.attack(enemies);
        assertEquals(100, enemies.get(0).getHealth());
    }
    @Test
    void testStartWave_WithEnemies() {
        Game game = new Game(mockMap);
        when(mockWave.generateEnemies()).thenReturn(List.of(new BasicEnemy().createEnemy()));
        game.setWave(mockWave);
        game.startWave();
        assertFalse(game.getEnemies().isEmpty());
    }
    @Test
    void testStartWave_NoEnemies() {
        Game game = new Game(mockMap);
        when(mockWave.generateEnemies()).thenReturn(Collections.emptyList());
        game.setWave(mockWave);
        game.startWave();
        assertTrue(game.getEnemies().isEmpty());
    }
    @Test
    void testIsValidPosition_Valid() {
        Map map = new Map();
        assertTrue(map.isValidPosition(0, 0));
    }
    @Test
    void testIsValidPosition_InvalidOccupied() {
        Map map = new Map();
        assertFalse(map.isValidPosition(0, 2));
    }
    @Test
    void testIsValidPosition_InvalidOutOfBounds() {
        Map map = new Map();
        assertFalse(map.isValidPosition(-3, 5));
    }
}
