package com.transitnetwork.model;

public class Station {
    private int stationId;
    private String name;
    private int xCoordinate;
    private int yCoordinate;

    // Empty constructor
    public Station() {}

    // Parameterized constructor
    public Station(int stationId, String name, int xCoordinate, int yCoordinate) {
        this.stationId = stationId;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    // Getters and Setters
    public int getStationId() { return stationId; }
    public void setStationId(int stationId) { this.stationId = stationId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getXCoordinate() { return xCoordinate; }
    public void setXCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }

    public int getYCoordinate() { return yCoordinate; }
    public void setYCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }

    // Helpful for printing to the console during testing
    @Override
    public String toString() {
        return name + " (" + xCoordinate + ", " + yCoordinate + ")";
    }
}