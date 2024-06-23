package org.example;

public class Enemy {
    private int speed;
    private int health;
    private int reward;
    private int x;
    private int y;
    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
}
