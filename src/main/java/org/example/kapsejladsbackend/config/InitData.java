package org.example.kapsejladsbackend.config;

import org.example.kapsejladsbackend.boat.Boat;
import org.example.kapsejladsbackend.boat.BoatRepository;
import org.example.kapsejladsbackend.boat.BoatType;
import org.example.kapsejladsbackend.participant.Participant;
import org.example.kapsejladsbackend.participant.ParticipantRepository;
import org.example.kapsejladsbackend.sailing.Sailing;
import org.example.kapsejladsbackend.sailing.SailingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class InitData implements CommandLineRunner {

    private final BoatRepository boatRepository;
    private final ParticipantRepository participantRepository;
    private final SailingRepository sailingRepository;

    public InitData(BoatRepository boatRepository, ParticipantRepository participantRepository, SailingRepository sailingRepository) {
        this.boatRepository = boatRepository;
        this.participantRepository = participantRepository;
        this.sailingRepository = sailingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Boat boat = new Boat();

        Participant participant = new Participant();
        Sailing sailing = new Sailing();

        boat.setBoatType(BoatType.BETWEEN_25_AND_40_FEET);
        boat.setParticipants(Set.of(participant));

        participant.setSailings(Set.of(sailing));

        sailingRepository.save(sailing);
        participantRepository.save(participant);
        boatRepository.save(boat);
    }
}
