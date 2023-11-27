package com.example.AircraftProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AircraftProject.HelicopterService;
import jakarta.validation.Valid;
import com.example.AircraftProject.Helicopter;
import java.util.List;

@RestController
@RequestMapping("/api/helicopters")
public class HelicopterController {

    @Autowired
    private HelicopterService helicopterService;

    @GetMapping
    public List<Helicopter> getAllHelicopters() {
        return helicopterService.getAllHelicopters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHelicopter(@PathVariable int id) {
        Helicopter helicopter = helicopterService.getHelicopterById(id);

        if (helicopter != null) {
            return ResponseEntity.status(HttpStatus.OK).body(helicopter);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Helicopter not found with ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addHelicopter(@Valid @RequestBody Helicopter helicopter) {
        if (helicopter.getName() == null || helicopter.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Helicopter name cannot be empty");
        }
        helicopterService.addHelicopter(helicopter);

        return ResponseEntity.status(HttpStatus.CREATED).body("helicopter successfully created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHelicopter(@PathVariable int id, @RequestBody Helicopter updatedHelicopter) {
        boolean FoundUpdated = helicopterService.updateHelicopter(id, updatedHelicopter);
        if (FoundUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Helicopter updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Helicopter not found with ID: " + id);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHelicopter(@PathVariable int id) {
        boolean FoundDeleted = helicopterService.deleteHelicopter(id);
        if (FoundDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Helicopter deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Helicopter not found with ID: " + id);
        }
    }
}
