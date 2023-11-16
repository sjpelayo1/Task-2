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

    public Jet getJetById(String name) {
        return jets.stream()
                .filter(jet -> jet.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addJet(Jet jet) {
        jets.add(jet);
    }

    public void updateJet(String name, Jet updatedJet) {
        Jet existingJet = getJetById(name);
        if (existingJet != null) {
            existingJet.setNumEngines(updatedJet.getNumEngines());
            existingJet.setNumWings(updatedJet.getNumWings());
            existingJet.setName(updatedJet.getName());
        }
    }

    public void deleteJet(String name) {
        jets.removeIf(jet -> jet.getName().equals(name));
    }
}
