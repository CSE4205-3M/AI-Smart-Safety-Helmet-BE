package com.AISmartSafetyHelmetBE.repository;

import com.AISmartSafetyHelmetBE.entity.SafetyRingLock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SafetyRingLockRepository extends JpaRepository<SafetyRingLock, UUID> {
}
