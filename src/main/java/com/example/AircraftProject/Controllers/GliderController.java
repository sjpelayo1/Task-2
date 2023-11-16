package com.example.AircraftProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AircraftProject.GliderService;
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

    @GetMapping("/{name}")
    public Glider getGlider(@PathVariable String name) {
        return gliderService.getGliderById(name);
    }

    @PostMapping
    public ResponseEntity<Object> addGlider(@RequestBody Glider glider) {
        gliderService.addGlider(glider);
        return ResponseEntity.status(HttpStatus.CREATED).body("Glider successfully created");
    }

    @PutMapping("/{name}")
    public ResponseEntity<Object> updateGlider(@PathVariable String name, @RequestBody Glider updatedGlider) {
        gliderService.updateGlider(name, updatedGlider);

        return ResponseEntity.status(HttpStatus.OK).body("Glider updated successfully");
    }

    @DeleteMapping("/{name}")
    public void deleteGlider(@PathVariable String name) {
        gliderService.deleteGlider(name);
    }
}
