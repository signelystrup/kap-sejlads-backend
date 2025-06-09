package org.example.kapsejladsbackend.sailing;

import org.example.kapsejladsbackend.boat.Boat;
import org.springframework.stereotype.Service;

@Service
public class SailingService {
    private final SailingRepository sailingRepository;

    public SailingService(SailingRepository sailingRepository) {
        this.sailingRepository = sailingRepository;
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
