package com.example.AircraftProject;

public abstract class Aircraft {
    protected String name;

    protected Aircraft(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}