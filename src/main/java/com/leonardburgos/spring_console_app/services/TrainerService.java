package com.leonardburgos.spring_console_app.services;

import com.leonardburgos.spring_console_app.model.Trainer;
import com.leonardburgos.spring_console_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final UserRepository userRepository;

    public void addTrainer(String username, String name, String lastName) {
        Trainer trainer = new Trainer(username, name, lastName);
        this.userRepository.addUser(username, trainer);
    }

    public Trainer getTrainer(String username) {
        return (Trainer) this.userRepository.getUser(username);
    }
}
