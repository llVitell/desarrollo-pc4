package org.example.towers;

import org.example.Tower;

public class CannonTower implements TowerFactory {
    @Override
    public Tower createTower(){
        return new Tower(50,2,3);
    }
}
