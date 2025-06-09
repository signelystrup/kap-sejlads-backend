package org.example.kapsejladsbackend.boat;

import org.springframework.stereotype.Service;

@Service
public class BoatService {
    private final BoatRepository boatRepository;

    public BoatService(BoatRepository boatRepository){
        this.boatRepository = boatRepository;
    }
}
