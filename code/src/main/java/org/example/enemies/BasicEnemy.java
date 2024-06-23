package org.example.enemies;

import org.example.Enemy;

public class BasicEnemy implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Enemy(1,100,10);
    }
}