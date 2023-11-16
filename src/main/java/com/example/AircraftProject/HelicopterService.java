package com.example.AircraftProject;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelicopterService {
    private List<Helicopter> helicopters = new ArrayList<>();

    public List<Helicopter> getAllHelicopters() {
        return helicopters;
    }

    public Helicopter getHelicopterById(String name) {
        return helicopters.stream()
                .filter(helicopter -> helicopter.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addHelicopter(Helicopter helicopter) {
        helicopters.add(helicopter);
    }

    public void updateHelicopter(String name, Helicopter updatedHelicopter) {
        Helicopter existingHelicopter = getHelicopterById(name);
        if (existingHelicopter != null) {
            existingHelicopter.setNumEngines(updatedHelicopter.getNumEngines());
            existingHelicopter.setNumBlades(updatedHelicopter.getNumBlades());
            existingHelicopter.setName(updatedHelicopter.getName());
        }
    }

    public void deleteHelicopter(String name) {
        helicopters.removeIf(helicopter -> helicopter.getName().equals(name));
    }
}
