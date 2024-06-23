package org.example.towers;

import org.example.Tower;

public class SniperTower implements TowerFactory {
    @Override
    public Tower createTower() {
        return new Tower(70,4,1);
    }
}
