package com.leonardburgos.spring_console_app.services;

import com.leonardburgos.spring_console_app.model.Trainer;
import com.leonardburgos.spring_console_app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {

    @Mock
    private UserRepository userRepository;

    private TrainerService trainerService;

    @BeforeAll
    public static void init() {
        MockitoAnnotations.openMocks(TrainerServiceTest.class);
    }

    @BeforeEach
    public void setUp() {
        trainerService = new TrainerService(this.userRepository);
    }

    @Test
    public void testAddTrainer() {
        // given
        String username = "trainer1";
        String name = "Leonard";
        String lastName = "Burgos";

        Trainer createdTrainer = new Trainer(username, name, lastName);

        // when
        Mockito.when(userRepository.addUser(Mockito.anyString(), Mockito.any())).thenReturn(createdTrainer);

        this.trainerService.addTrainer(username, name, lastName);

        // then
        Mockito.verify(userRepository).addUser(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void testGetTrainer() {
        // Given
        String username = "trainer1";
        Trainer trainer1 = new Trainer(username, "Leonard", "Burgos");

        // Mocks
        Mockito.when(userRepository.getUser(username)).thenReturn(trainer1);

        // When
        Trainer trainer = this.trainerService.getTrainer(username);

        // Then
        Assertions.assertEquals(trainer1, trainer);
    }
}
