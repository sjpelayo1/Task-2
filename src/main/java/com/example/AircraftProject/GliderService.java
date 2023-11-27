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

    public Glider getGliderById(int id) {
        return gliders.stream()
                .filter(glider -> glider.getID() == id)
                .findFirst()
                .orElse(null);
    }

    public void addGlider(Glider glider) {
        gliders.add(glider);
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