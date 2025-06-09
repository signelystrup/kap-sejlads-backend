package org.example.kapsejladsbackend.participant;

import org.example.kapsejladsbackend.boat.Boat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/all")
    public void getAllParticipants(){

    }

    @GetMapping("/{id}")
    public void getParticipantById(@PathVariable long id){

    }

    @PostMapping
    public void addParticipant(@RequestBody Boat boat){

    }

    @PutMapping("/{id}")
    public void updateParticipant(@PathVariable long id, @RequestBody Boat boat){

    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable long id){

    }
}
