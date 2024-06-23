package org.example;

public class Map {
    private char[][] map = {
            {' ', ' ', 'C', ' ', ' '},
            {' ', 'C', ' ', ' ', ' '},
            {'C', ' ', ' ', 'C', 'B'},
            {' ', ' ', 'C', ' ', ' '},
            {' ', ' ', ' ', ' ', ' '}
    };
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] == ' ';
    }
    public void placeTower(Tower tower,int x, int y){
        if(isValidPosition(x,y)){
            map[x][y] = 'T';
        }
    }
}
