package org.example;

import java.util.List;

public class Game {
    Map map;
    Wave wave;
    List<Enemy> enemies;
    public Game(Map map){
        this.map = map;
    }
    public void placeTower(Tower tower, int x, int y){
        if (map.isValidPosition(x, y)) {
            map.placeTower(tower, x, y);
        }
    }
    public void setWave(Wave wave) {
        this.wave = wave;
    }
    public void startWave() {
        this.enemies = wave.generateEnemies();
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }

}
