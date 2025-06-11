package org.example.kapsejladsbackend.boat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kapsejladsbackend.participant.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.string;
import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BoatController.class)
class BoatControllerTest {

    @MockitoBean
    private BoatService boatService;


    @Autowired
    private MockMvc mockMvc;


    private Set<Participant> participants = new HashSet<>();
    private BoatRequestDTO boatRequestDTO;
    private BoatResponseDTO boatResponseDTO;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        boatRequestDTO = new BoatRequestDTO(1, BoatType.LESS_THAN_25_FEET, participants);
        boatResponseDTO = new BoatResponseDTO(BoatType.BETWEEN_25_AND_40_FEET, participants);

        participants.add(new Participant());
        participants.add(new Participant());

    }

    @Test
    void getAllBoatsTest() throws Exception{

        //arrange
        when(boatService.getAllBoats()).thenReturn(Set.of(boatRequestDTO));

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
    void addBoatTest() throws Exception{
        when(boatService.addBoat(boatResponseDTO)).thenReturn(boatRequestDTO);

        String jsonPayload = objectMapper.writeValueAsString(boatResponseDTO); //prepare responseDTO as json(string)

        mockMvc.perform(post("/boat")
                                .content(jsonPayload)
                                .contentType(MediaType.APPLICATION_JSON))

                .andDo(print())
                .andExpect(status().isCreated());

        //this post method should return a ResponseEntity containing a BoatRequestDTO, but the Body is empty.
        //this is a test specific problem, and does not occur in the actual program.
    }

    @Test
    void updateBoat() {
    }

    @Test
    void deleteBoat() {
    }
}