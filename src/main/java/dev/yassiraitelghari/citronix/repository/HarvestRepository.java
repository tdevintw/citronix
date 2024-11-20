package dev.yassiraitelghari.citronix.repository;

import dev.yassiraitelghari.citronix.domain.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest , UUID> {
    @Query("SELECT SUM(hd.quantity) FROM HarvestDetail hd WHERE hd.tree.field.id =:id AND hd.harvest IS NULL")
    double totalQuantityOfHarvestTreesOfAField(UUID id);
}
