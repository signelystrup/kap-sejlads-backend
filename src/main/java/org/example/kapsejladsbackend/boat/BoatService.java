package org.example.kapsejladsbackend.boat;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BoatService {
    private final BoatRepository boatRepository;

    public BoatService(BoatRepository boatRepository){
        this.boatRepository = boatRepository;
    }

    public Set<BoatRequestDTO> getAllBoats(){
        return boatRepository.findAll()
                       .stream()
                       .map(BoatRequestDTO::boatToRequestDTO)
                       .collect(Collectors.toSet());
    }

    public BoatRequestDTO getBoatById( long id){
        Optional<Boat> boat = boatRepository.findById(id);
        if (boat.isPresent()){
            return BoatRequestDTO.boatToRequestDTO(boat.get());
        }

        return null;

    }

    public void addBoat(Boat boat){

    }

    public void updateBoat(long id, Boat boat){

    }

    public void deleteBoat(long id){

    }
}
