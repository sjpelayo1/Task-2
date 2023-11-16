package com.example.AircraftProject;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GliderService {

    private List<Glider> gliders = new ArrayList<>();

    public List<Glider> getAllGliders() {
        return gliders;
    }

    public Glider getGliderById(String name) {
        return gliders.stream()
                .filter(glider -> glider.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addGlider(Glider glider) {
        gliders.add(glider);
    }

    public void updateGlider(String name, Glider updatedGlider) {
        Glider existingGlider = getGliderById(name);
        if (existingGlider != null) {
            existingGlider.setNumWings(updatedGlider.getNumWings());
            existingGlider.setName(updatedGlider.getName());
        }
    }

    public void deleteGlider(String name) {
        gliders.removeIf(glider -> glider.getName().equals(name));
    }
}
