package com.example.AircraftProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AircraftProject.GliderService;
import jakarta.validation.Valid;
import com.example.AircraftProject.Glider;
import java.util.List;

@RestController
@RequestMapping("/api/gliders")
public class GliderController {

    @Autowired
    private GliderService gliderService;

    @GetMapping
    public List<Glider> getAllGliders() {
        return gliderService.getAllGliders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGlider(@PathVariable int id) {
        Glider glider = gliderService.getGliderById(id);

        if (glider != null) {
            return ResponseEntity.status(HttpStatus.OK).body(glider);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Glider not found with ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addGlider(@Valid @RequestBody Glider glider) {
        if (glider.getName() == null || glider.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Glider name cannot be empty");
        }
        gliderService.addGlider(glider);
        return ResponseEntity.status(HttpStatus.CREATED).body("Glider successfully created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGlider(@PathVariable int id, @RequestBody Glider updatedGlider) {
        boolean FoundUpdated = gliderService.updateGlider(id, updatedGlider);
        if (FoundUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Glider updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Glider not found with ID: " + id);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGlider(@PathVariable int id) {
        boolean FoundDeleted = gliderService.deleteGlider(id);
        if (FoundDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Glider deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Glider not found with ID: " + id);
        }
    }
}
