package org.example.kapsejladsbackend.sailing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SailingRepository extends JpaRepository<Sailing, Long> {

}
