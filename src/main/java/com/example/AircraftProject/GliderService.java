package com.example.AircraftProject;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GliderService {

    private List<Glider> gliders = new ArrayList<>();
    private int counter = 1;

    public List<Glider> getAllGliders() {
        return gliders;
    }

    public Glider getGliderById(int id) {
        return gliders.stream()
                .filter(glider -> glider.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addGlider(Glider glider) {
        glider.setId(counter); // Set the ID for the glider
        gliders.add(glider);
        counter++;
    }

    public boolean updateGlider(int id, Glider updatedGlider) {
        Glider existingGlider = getGliderById(id);
        if (existingGlider != null) {
            existingGlider.setNumWings(updatedGlider.getNumWings());
            existingGlider.setName(updatedGlider.getName());

            return true;
        } else {
            return false;

        }
    }

    public boolean deleteGlider(int id) {
        Glider gliderToRemove = getGliderById(id);
        if (gliderToRemove != null) {
            gliders.remove(gliderToRemove);
            return true;
        } else {
            return false;
        }

    }
}