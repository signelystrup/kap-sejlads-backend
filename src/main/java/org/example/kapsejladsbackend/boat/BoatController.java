package org.example.kapsejladsbackend.boat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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
    public ResponseEntity<BoatRequestDTO> getBoatById(@PathVariable long id){
        BoatRequestDTO boat = boatService.getBoatById(id);

        if (boat == null){ //if no boat with id found, throw 404
            return new ResponseEntity<>(boat,
                                        HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(boat, //return boatDTO and 200 ok.
                                    HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatRequestDTO> addBoat(@RequestBody BoatResponseDTO boatResponseDTO){
        return new ResponseEntity<>(boatService.addBoat(boatResponseDTO),
                                    HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoatRequestDTO> updateBoat(@PathVariable long id, @RequestBody BoatResponseDTO boatResponseDTO){
        BoatRequestDTO boatRequestDTO = boatService.updateBoat(id, boatResponseDTO); //update boat

        if (getBoatById(id) == null){ //if no boat with id, return 201
            return new ResponseEntity<>(boatRequestDTO,
                                        HttpStatus.CREATED);
        }

        return new ResponseEntity<>(boatRequestDTO, //if boat updated (exists) return 200
                                    HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBoat(@PathVariable long id){
        boolean deleted = boatService.deleteBoat(id);
        
        if (deleted){
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
