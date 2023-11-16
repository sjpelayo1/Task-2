package com.example.AircraftProject;

public class Glider extends Aircraft {
    private int numWings;

    public Glider(String name, int numWings) {
        super(name);
        this.numWings = numWings;
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
        return "Glider Name: " + super.getName() + ", Number of Wings: " + numWings;
    }
}
