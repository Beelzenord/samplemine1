package model;

import java.util.ArrayList;

public class Zone {
    private ArrayList<Zone> adjacentZone = new ArrayList<>();
    private int nearbyBombs;
    private boolean hasBomb;
    private boolean flagged;
    private final int x;
    private final int y;
    
    public Zone(int x_, int y_) {
        this.x = x_;
        this.y = y_;
        this.hasBomb = false;
        this.flagged = false;
        this.nearbyBombs = 0;
    }
    
    public void plantBomb() {
        this.hasBomb = true;
        for (Zone z: this.adjacentZone) {
            z.increaseNearbyBombs();
        }
    }
    
    public void addAdjacentZone(Zone z) {
        if (!(z == null)) 
            this.adjacentZone.add(z);
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getNearbyBombs() {
        return this.nearbyBombs;
    }

    public boolean hasBomb() {
        return this.hasBomb;
    }
    
    public void increaseNearbyBombs() {
        this.nearbyBombs++;
    }
    
    public void toggleFlag() {
        this.flagged = !this.flagged;
    }
}
