package com.AISmartSafetyHelmetBE.repository;

import com.AISmartSafetyHelmetBE.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    @Query(nativeQuery = true, value = "select * from worker where raspberry_pi_id = :id")
    Worker findByRaspberryPiId(@Param("id")String id);
}
