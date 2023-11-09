package com.AISmartSafetyHelmetBE.repository;

import com.AISmartSafetyHelmetBE.entity.Commute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommuteRepository extends JpaRepository<Commute, UUID> {
}
