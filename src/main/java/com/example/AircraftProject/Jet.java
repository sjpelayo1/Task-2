package com.example.AircraftProject;

public class Jet extends Aircraft {
    private int numEngines;
    private int numWings;
    private static int idCount = 1;
    private int id;

    public Jet(String name, int numEngines, int numWings, int id) {
        super(name);
        this.numEngines = numEngines;
        this.numWings = numWings;
        this.id = idCount++;
    }

    public int getID() {
        return id;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    public int getNumWings() {
        return numWings;
    }

    public void setNumWings(int numWings) {
        this.numWings = numWings;
    }

    @Override
    public String toString() {
        return "Jet Name: " + name +
                ", Number of Engines: " + numEngines +
                ", Number of Wings: " + numWings;
    }
}