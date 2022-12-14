package com.pruebas_software;

public class Location {

    private int floor;
    private int hallway;
    private int shelf;
    private int xPosition;
    private int yPosition;

    // Builders

    public Location(){
        this.floor = 0;
        this.hallway = 0;
        this.shelf = 0;
        this.xPosition = 0;
        this.yPosition = 0;
    }

    public Location(int floor, int hallway,  int shelf, int xPosition, int yPosition) {
        this.floor = floor;
        this.hallway = hallway;
        this.shelf = shelf;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    // Getters

    public int getFloor(){ return this.floor; }

    public int getHallway(){ return this.hallway; }

    public int getShelf(){ return this.shelf; } 

    public int getXPosition(){ return this.xPosition; }

    public int getYPosition(){ return this.yPosition; }

    // Setters

    public void setFloor(int floor) { this.floor = floor; }

    public void setHallway(int hallway){ this.hallway = hallway; }

    public void setShelf(int shelf){ this.shelf = shelf; }

    public void setXPosition(int xPosition){ this.xPosition = xPosition; }

    public void setYPosition(int yPosition){ this.yPosition = yPosition; }
}
