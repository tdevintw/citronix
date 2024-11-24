package dev.yassiraitelghari.citronix.repository.criteria;

import dev.yassiraitelghari.citronix.domain.Farm;

import java.util.List;

public interface FarmRepositoryCustom {
    List<Farm> findFarmsByCriteria(String name, String location, Integer minTrees);

}
