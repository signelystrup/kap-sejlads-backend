package org.example.kapsejladsbackend.boat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boat")
public class BoatController {
    private final BoatService boatService;

    public BoatController(BoatService boatService){
        this.boatService = boatService;
    }

}
