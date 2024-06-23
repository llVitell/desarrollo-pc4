package org.example.enemies;

import org.example.Enemy;

public class BossEnemy implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Enemy(1,500,50);
    }
}
