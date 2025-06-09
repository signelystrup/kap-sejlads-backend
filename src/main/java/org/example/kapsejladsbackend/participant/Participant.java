package org.example.kapsejladsbackend.participant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.kapsejladsbackend.boat.Boat;
import org.example.kapsejladsbackend.sailing.Sailing;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(name = "participant_boat",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "boat_id")
    )
    private Set<Boat> boats;

    @ManyToMany
    @JoinTable(name = "participant_sailing",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "sailing_id")
    )
    private Set<Sailing> sailings;
}
