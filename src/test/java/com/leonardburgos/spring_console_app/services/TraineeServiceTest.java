package com.leonardburgos.spring_console_app.services;

import com.leonardburgos.spring_console_app.model.Trainee;
import com.leonardburgos.spring_console_app.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TraineeServiceTest {

    @Mock
    private UserRepository userRepository;

    private TraineeService traineeService;

    @BeforeAll
    public static void setUp() {
        MockitoAnnotations.initMocks(TraineeServiceTest.class);
    }

    @BeforeEach
    public void init() {
        this.traineeService = new TraineeService(userRepository);
    }

    @Test
    void addTraineeTest() {
        // given
        String username = "trainer1";
        String name = "John";
        String sureName = "Doe";

        Trainee createdTrainee = new Trainee(username, name, sureName);

        // Mocks
        Mockito.when(userRepository.addUser(Mockito.anyString(), Mockito.any())).thenReturn(createdTrainee);

        // When
        this.traineeService.addTrainee(username, name, sureName);

        // Then
        Mockito.verify(userRepository).addUser(Mockito.anyString(), Mockito.any());
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsNull() {
        // Given
        String username = null;
        String name = "John";
        String sureName = "Doe";

        // When - Assertion
        Assertions.assertThatThrownBy(
                () -> this.traineeService.addTrainee(username, name, sureName)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsEmpty() {
        // Given
        String username = "";
        String name = "John";
        String sureName = "Doe";

        // When - Assertion
        Assertions.assertThatThrownBy(
                () -> this.traineeService.addTrainee(username, name, sureName)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
