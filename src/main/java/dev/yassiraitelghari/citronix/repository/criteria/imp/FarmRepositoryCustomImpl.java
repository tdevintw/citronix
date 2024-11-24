package dev.yassiraitelghari.citronix.repository.criteria.imp;

import dev.yassiraitelghari.citronix.domain.Farm;
import dev.yassiraitelghari.citronix.repository.criteria.FarmRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FarmRepositoryCustomImpl implements FarmRepositoryCustom {
    private final EntityManager entityManager;

    public FarmRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Farm> findFarmsByCriteria(String name, String location, Integer minTrees){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> query = cb.createQuery(Farm.class);
        Root<Farm> farm = query.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(farm.get("name"), "%" + name + "%"));
        }

        if (location != null && !location.isEmpty()) {
            predicates.add(cb.equal(farm.get("location"), location));
        }

        if (minTrees != null) {
            predicates.add(cb.greaterThanOrEqualTo(farm.get("numberOfTrees"), minTrees));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
