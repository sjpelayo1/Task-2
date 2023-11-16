package com.example.AircraftProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AircraftProject.JetService;
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

    @GetMapping("/{name}")
    public Jet getJet(@PathVariable String name) {
        return jetService.getJetById(name);
    }

    @PostMapping
    public ResponseEntity<Object> addJet(@RequestBody Jet jet) {
        jetService.addJet(jet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Jet successfully created");
    }

    @PutMapping("/{name}")
    public ResponseEntity<Object> updateJet(@PathVariable String name,
            @RequestBody Jet updatedJet) {
        jetService.updateJet(name, updatedJet);

        return ResponseEntity.status(HttpStatus.OK).body("Jet updated successfully");
    }

    @DeleteMapping("/{name}")
    public void deleteJet(@PathVariable String name) {
        jetService.deleteJet(name);
    }

}
