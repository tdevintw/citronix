package dev.yassiraitelghari.citronix.repository;

import dev.yassiraitelghari.citronix.domain.HarvestDetail;
import dev.yassiraitelghari.citronix.domain.Tree;
import dev.yassiraitelghari.citronix.domain.enums.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HarvestDetailRepository extends JpaRepository<HarvestDetail , UUID> {
    int countHarvestDetailByTreeAndSeason(Tree tree , Season season);
}
