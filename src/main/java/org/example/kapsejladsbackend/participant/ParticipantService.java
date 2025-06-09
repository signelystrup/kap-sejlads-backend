package org.example.kapsejladsbackend.participant;

import org.example.kapsejladsbackend.boat.Boat;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    public void getAllBoats(){

    }

    public void getBoatById( long id){

    }

    public void addBoat(Boat boat){

    }

    public void updateBoat(long id, Boat boat){

    }

    public void deleteBoat(long id){

    }
}

