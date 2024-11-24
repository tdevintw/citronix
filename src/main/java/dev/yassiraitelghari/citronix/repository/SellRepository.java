package dev.yassiraitelghari.citronix.repository;

import dev.yassiraitelghari.citronix.domain.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellRepository extends JpaRepository<Sell , UUID> {
}
