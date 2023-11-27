package com.example.AircraftProject;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JetService {

    private List<Jet> jets = new ArrayList<>();

    public List<Jet> getAllJets() {
        return jets;
    }

    public Jet getJetById(int id) {
        return jets.stream()
                .filter(jet -> jet.getID() == id)
                .findFirst()
                .orElse(null);
    }

    public void addJet(Jet jet) {
        jets.add(jet);
    }

    public boolean updateJet(int id, Jet updatedJet) {
        Jet existingJet = getJetById(id);
        if (existingJet != null) {
            existingJet.setNumWings(updatedJet.getNumWings());
            existingJet.setNumEngines(updatedJet.getNumEngines());
            existingJet.setName(updatedJet.getName());

            return true;
        } else {
            return false;

        }
    }

    public boolean deleteJet(int id) {
        Jet jetToRemove = getJetById(id);
        if (jetToRemove != null) {
            jets.remove(jetToRemove);
            return true;
        } else {
            return false;
        }

    }
}