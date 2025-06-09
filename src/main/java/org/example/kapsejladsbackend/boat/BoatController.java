package org.example.kapsejladsbackend.boat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/boat")
public class BoatController {
    private final BoatService boatService;

    public BoatController(BoatService boatService){
        this.boatService = boatService;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Boat>> getAllBoats(){
        Set<Boat> boats = boatService.getAllBoats();
    }

    @GetMapping("/{id}")
    public void getBoatById(@PathVariable long id){

    }

    @PostMapping
    public void addBoat(@RequestBody Boat boat){

    }

    @PutMapping("/{id}")
    public void updateBoat(@PathVariable long id, @RequestBody Boat boat){

    }

    @DeleteMapping("/{id}")
    public void deleteBoat(@PathVariable long id){

    }

}
