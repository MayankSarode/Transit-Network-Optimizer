package com.transitnetwork.model;

public class Route implements Comparable<Route> {
    private int routeId;
    private int sourceId;
    private int destinationId;
    private double weight;

    // Empty constructor
    public Route() {}

    // Parameterized constructor
    public Route(int routeId, int sourceId, int destinationId, double weight) {
        this.routeId = routeId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.weight = weight;
    }

    // Getters and Setters
    public int getRouteId() { return routeId; }
    public void setRouteId(int routeId) { this.routeId = routeId; }

    public int getSourceId() { return sourceId; }
    public void setSourceId(int sourceId) { this.sourceId = sourceId; }

    public int getDestinationId() { return destinationId; }
    public void setDestinationId(int destinationId) { this.destinationId = destinationId; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // This is required by Comparable. It allows Java's Collections.sort() 
    // to instantly order our routes from shortest to longest.
    @Override
    public int compareTo(Route other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Route{" + sourceId + " -> " + destinationId + ", weight=" + weight + "}";
    }
}