package org.example.kapsejladsbackend.sailing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sailing")
public class SailingController {
    private final SailingService sailingService;

    public SailingController(SailingService sailingService) {
        this.sailingService = sailingService;
    }
}
