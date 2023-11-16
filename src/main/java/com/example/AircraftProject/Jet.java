package com.example.AircraftProject;

public class Jet extends Aircraft {
    private int numEngines;
    private int numWings;

    public Jet(String name, int numEngines, int numWings) {
        super(name);
        this.numEngines = numEngines;
        this.numWings = numWings;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Jet Name: " + super.getName() +
                ", Number of Engines: " + getNumEngines() +
                ", Number of Wings: " + getNumWings();
    }
}