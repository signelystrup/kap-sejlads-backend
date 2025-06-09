package org.example.kapsejladsbackend.sailing;

import org.example.kapsejladsbackend.boat.Boat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sailing")
public class SailingController {
    private final SailingService sailingService;

    public SailingController(SailingService sailingService) {
        this.sailingService = sailingService;
    }

    @GetMapping("/all")
    public void getAllSailings(){

    }

    @GetMapping("/{id}")
    public void getSailingById(@PathVariable long id){

    }

    @PostMapping
    public void addSailing(@RequestBody Boat boat){

    }

    @PutMapping("/{id}")
    public void updateSailing(@PathVariable long id, @RequestBody Boat boat){

    }

    @DeleteMapping("/{id}")
    public void deleteSailing(@PathVariable long id){

    }

}
