package com.example.AircraftProject;

public class Helicopter extends Aircraft {

    private int numEngines;
    private int numBlades;

    public Helicopter(String name, int numEngines, int numBlades, int id) {
        super(name, id);
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

    @Override
    public String toString() {
        return "Helicopter Name: " + name +
                ", Number of Engines: " + numEngines +
                ", Number of Blades: " + numBlades +
                "ID: " + id;
    }

}