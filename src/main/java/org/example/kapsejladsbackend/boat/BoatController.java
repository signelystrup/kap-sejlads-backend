package org.example.kapsejladsbackend.boat;

import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Set<BoatRequestDTO>> getAllBoats(){
        Set<BoatRequestDTO> boats = boatService.getAllBoats();

        return new ResponseEntity<>(boats, HttpStatus.OK);
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
