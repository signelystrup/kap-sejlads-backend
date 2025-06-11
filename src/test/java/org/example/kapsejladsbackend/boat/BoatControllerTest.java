package org.example.kapsejladsbackend.boat;

import org.example.kapsejladsbackend.participant.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoatController.class)
class BoatControllerTest {

    @MockitoBean
    private BoatService boatService;

    @Autowired
    private MockMvc mockMvc;

    private Set<Participant> participants = new HashSet<>();

    @BeforeEach
    void setUp() {
        participants.add(new Participant());
        participants.add(new Participant());

    }

    @Test
    void getAllBoatsTest() throws Exception{

        BoatRequestDTO boat = new BoatRequestDTO(1, BoatType.LESS_THAN_25_FEET, participants);

        when(boatService.getAllBoats()).thenReturn(Set.of(boat));

        mockMvc.perform(get("/boat/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))       //check for boat quantity
                .andExpect(jsonPath("$[0].id").value(1))        //check id == 1
                .andExpect(jsonPath("$[0].participants.size()").value(2));  //check how many participants associated with boat.
    }

    @Test
    void getBoatById() {
    }

    @Test
    void addBoat() {
    }

    @Test
    void updateBoat() {
    }

    @Test
    void deleteBoat() {
    }
}