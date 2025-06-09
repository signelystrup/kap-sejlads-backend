package org.example.kapsejladsbackend.boat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kapsejladsbackend.participant.Participant;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BoatType boatType;

    @ManyToMany
    private Set<Participant> participants;

    //no id
    public Boat(Set<Participant> participants, BoatType boatType) {
        this.participants = participants;
        this.boatType = boatType;
    }
}
