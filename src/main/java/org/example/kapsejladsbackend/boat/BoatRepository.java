package org.example.kapsejladsbackend.boat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {

}
