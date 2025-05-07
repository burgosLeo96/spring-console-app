package com.leonardburgos.spring_console_app.controller;

import com.leonardburgos.spring_console_app.model.Trainer;
import com.leonardburgos.spring_console_app.services.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        trainerService.addTrainer(trainer.username(), trainer.trainerName(), trainer.trainerLastName());
        return trainer;
    }

    @GetMapping("/{trainerUsername}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable String trainerUsername) {
        return ResponseEntity.ok(trainerService.getTrainer(trainerUsername));
    }

}
