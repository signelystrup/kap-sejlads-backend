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

    public BoatRequestDTO addBoat(BoatResponseDTO boatResponseDTO){
        return BoatRequestDTO.boatToRequestDTO(boatRepository.save(
                BoatResponseDTO.boatFromResponseDTO(boatResponseDTO))
        );
    }

    public BoatRequestDTO updateBoat(long id, BoatResponseDTO boatResponseDTO){
        Boat boat = BoatResponseDTO.boatFromResponseDTO(boatResponseDTO); //create boat from response dto

        if (boatRepository.findById(id).isPresent()){
            boat.setId(id);
        }

        return BoatRequestDTO.boatToRequestDTO(boatRepository.save(boat));
    }

    public boolean deleteBoat(long id){
        Optional <Boat> boat = boatRepository.findById(id);

        if (boat.isPresent()){
            boatRepository.delete(boat.get());
            return true;
        }
        return false;
    }
}
