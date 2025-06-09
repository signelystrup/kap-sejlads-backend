package org.example.kapsejladsbackend.sailing;

import org.springframework.stereotype.Service;

@Service
public class SailingService {
    private final SailingRepository sailingRepository;

    public SailingService(SailingRepository sailingRepository) {
        this.sailingRepository = sailingRepository;
    }
}
