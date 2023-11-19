package com.AISmartSafetyHelmetBE.repository;

import com.AISmartSafetyHelmetBE.entity.SafetyHookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SafetyHookStatusRepository extends JpaRepository<SafetyHookStatus, UUID> {
}
