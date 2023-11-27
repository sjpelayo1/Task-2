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

    public Helicopter getHelicopterById(int id) {
        return helicopters.stream()
                .filter(helicopter -> helicopter.getID() == id)
                .findFirst()
                .orElse(null);
    }

    public void addHelicopter(Helicopter helicopter) {
        helicopters.add(helicopter);
    }

    public boolean updateHelicopter(int id, Helicopter updatedHelicopter) {
        Helicopter existingHelicopter = getHelicopterById(id);
        if (existingHelicopter  != null) {
            existingHelicopter.setNumBlades(updatedHelicopter.getNumBlades());
            existingHelicopter.setNumEngines(updatedHelicopter.getNumEngines());
            existingHelicopter.setName(updatedHelicopter.getName());

            return true;
        } else {
            return false;

        }
    }

    public boolean deleteHelicopter(int id) {
        Helicopter helicopterToRemove   getHelicopterById(id);
        if (helicopterToRemove != null) {
            helicopters.remove(helicopterToRemove);
            
            return true;
        } else {
            return false;
        }

    }
}