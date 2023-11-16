package com.example.AircraftProject;

public class Helicopter extends Aircraft {

    private int numEngines;
    private int numBlades;

    public Helicopter(String name, int numEngines, int numBlades) {
        super(name);
        this.numEngines = numEngines;
        this.numBlades = numBlades;
    }

    public int getNumEngines() {
        return numEngines;
    }

    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }

    public int getNumBlades() {
        return numBlades;
    }

    public void setNumBlades(int numBlades) {
        this.numBlades = numBlades;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Helicopter Name: " + super.getName() +
                ", Number of Engines: " + getNumEngines() +
                ", Number of Blades: " + getNumBlades();
    }

}