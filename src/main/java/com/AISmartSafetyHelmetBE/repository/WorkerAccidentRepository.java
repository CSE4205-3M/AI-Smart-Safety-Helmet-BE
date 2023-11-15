package com.AISmartSafetyHelmetBE.repository;

import com.AISmartSafetyHelmetBE.entity.WorkerAccident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerAccidentRepository extends JpaRepository<WorkerAccident, UUID> {
}
