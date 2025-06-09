package org.example.kapsejladsbackend.boat;

import org.example.kapsejladsbackend.participant.Participant;

import java.util.Set;

public record BoatResponseDTO (BoatType boatType, Set<Participant> participants){
    public static Boat boatFromResponseDTO(BoatResponseDTO boatResponseDTO){
        return new Boat(boatResponseDTO.boatType, boatResponseDTO.participants);
    }
}
