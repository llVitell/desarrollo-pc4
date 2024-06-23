package org.example.enemies;

import org.example.Enemy;

public class SpeedyEnemy implements EnemyFactory{
    @Override
    public Enemy createEnemy(){
        return new Enemy(2,50,20);
    }
}


