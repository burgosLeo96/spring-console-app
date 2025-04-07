package com.leonardburgos.spring_console_app.services;

import com.leonardburgos.spring_console_app.model.Trainee;
import com.leonardburgos.spring_console_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraineeService {

    private final UserRepository userRepository;

    public void addTrainee(String username, String name, String lastName) {
        Trainee trainee = new Trainee(username, name, lastName);
        this.userRepository.addUser(username, trainee);
    }
}
