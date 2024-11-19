package dev.yassiraitelghari.citronix.repository;

import dev.yassiraitelghari.citronix.domain.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FarmRepository extends JpaRepository<Farm, UUID> {

    @Query("SELECT f FROM Farm f JOIN Field fi ON f.id = fi.farm.id GROUP BY f.id HAVING SUM(fi.area) < 4000")
    List<Farm> farmsWithFieldsAreaLessThen4000M();

    @Query("SELECT COUNT(*) FROM Field f WHERE f.farm.id =:id")
    int countFieldsOfAFarm(UUID id);

    @Query("SELECT SUM(f.area) FROM Field  f WHERE f.farm.id=:id")
    Integer sumOfFieldAreaOfFarm(UUID id);


}
