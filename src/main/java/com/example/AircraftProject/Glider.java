package com.example.AircraftProject;

public class Glider extends Aircraft {
    private static int idCount = 1;
    private int id;
    private int numWings;

    public Glider(String name, int numWings, int id) {
        super(name);
        this.id = idCount++;
        this.numWings = numWings;
    }

    public int getID() {
        return id;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Glider Name: " + name + ", Number of Wings: " + numWings;
    }
}
