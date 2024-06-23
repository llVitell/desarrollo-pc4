package org.example;

import org.example.enemies.BasicEnemy;
import org.example.enemies.BossEnemy;
import org.example.enemies.EnemyFactory;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    public List<Enemy> enemies = new ArrayList<>();
    private int waveNumber;

    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
        this.enemies = generateEnemies();
    }
    public List<Enemy> generateEnemies() {
        for (int i = 0; i < waveNumber * 5; i++) { // más enemigos cada oleada
            if (waveNumber % 5 == 0) { // jefe cada 5 oleadas
                enemies.add(new BossEnemy().createEnemy());
            }
            enemies.add(new BasicEnemy().createEnemy());
        }
        return enemies;
    }
    // Métodos para manejar el progreso de la oleada
}

