package com.AISmartSafetyHelmetBE.repository;

import com.AISmartSafetyHelmetBE.entity.WorkerFall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerFallRepository extends JpaRepository<WorkerFall, UUID> {
}
