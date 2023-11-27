package com.example.AircraftProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AircraftProject.JetService;
import jakarta.validation.Valid;
import com.example.AircraftProject.Jet;
import java.util.List;

@RestController
@RequestMapping("/api/jets")
public class JetController {

    @Autowired
    private JetService jetService;

    @GetMapping
    public List<Jet> getAllJets() {
        return jetService.getAllJets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getJet(@PathVariable int id) {
        Jet jet = jetService.getJetById(id);

        if (jet != null) {
            return ResponseEntity.status(HttpStatus.OK).body(jet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jet not found with ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addJet(@Valid @RequestBody Jet jet) {
        if (jet.getName() == null || jet.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Jet name cannot be empty");
        }
        jetService.addJet(jet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jet successfully created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJet(@PathVariable int id, @RequestBody Jet updatedJet) {
        boolean FoundUpdated = jetService.updateJet(id, updatedJet);
        if (FoundUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Jet updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jet not found with ID: " + id);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJet(@PathVariable int id) {
        boolean FoundDeleted = jetService.deleteJet(id);
        if (FoundDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Jet deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jet not found with ID: " + id);
        }
    }
}
