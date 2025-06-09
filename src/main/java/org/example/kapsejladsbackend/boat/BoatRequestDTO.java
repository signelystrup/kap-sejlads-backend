package org.example.kapsejladsbackend.boat;

import org.example.kapsejladsbackend.participant.Participant;

import java.util.Set;

public record BoatRequestDTO(long id, BoatType boatType, Set<Participant> participants) {
    public static BoatRequestDTO boatToRequestDTO(Boat boat){
        long id = boat.getId();
        BoatType boatType = boat.getBoatType();
        Set<Participant> participants = boat.getParticipants();

        return new BoatRequestDTO(id, boatType, participants);
    }
}
