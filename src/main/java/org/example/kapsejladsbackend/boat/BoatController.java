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

        if (boat == null){
            return new ResponseEntity<>(boat, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(boat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoatRequestDTO> addBoat(@RequestBody BoatResponseDTO boatResponseDTO){
        return new ResponseEntity<>(boatService.addBoat(boatResponseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoatRequestDTO> updateBoat(@PathVariable long id, @RequestBody BoatResponseDTO boatResponseDTO){
        BoatRequestDTO boatRequestDTO = boatService.updateBoat(id, boatResponseDTO);

        if (getBoatById(id) == null){
            return new ResponseEntity<>(boatRequestDTO, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(boatRequestDTO, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBoat(@PathVariable long id){
        boolean deleted = boatService.deleteBoat(id);
        if (deleted){
            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }

}
