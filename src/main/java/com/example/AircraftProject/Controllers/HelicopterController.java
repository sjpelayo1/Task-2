package com.example.AircraftProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.AircraftProject.HelicopterService;
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

    @GetMapping("/{name}")
    public Helicopter getHelicopter(@PathVariable String name) {
        return helicopterService.getHelicopterById(name);
    }

    @PostMapping
    public ResponseEntity<Object> addHelicopter(@RequestBody Helicopter helicopter) {
        helicopterService.addHelicopter(helicopter);
        return ResponseEntity.status(HttpStatus.CREATED).body("Helicopter successfully created");
    }

    @PutMapping("/{name}")
    public ResponseEntity<Object> updateHelicopter(@PathVariable String name,
            @RequestBody Helicopter updatedHelicopter) {
        helicopterService.updateHelicopter(name, updatedHelicopter);

        return ResponseEntity.status(HttpStatus.OK).body("Helicopter updated successfully");
    }

    @DeleteMapping("/{name}")
    public void deleteHelicopter(@PathVariable String name) {
        helicopterService.deleteHelicopter(name);
    }

}
