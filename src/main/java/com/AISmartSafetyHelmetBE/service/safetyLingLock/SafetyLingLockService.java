package com.AISmartSafetyHelmetBE.service.safetyLingLock;


import com.AISmartSafetyHelmetBE.dto.safetyLingLock.SafetyLingLockRequestDto;
import com.AISmartSafetyHelmetBE.entity.SafetyRingLock;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.repository.SafetyRingLockRepository;
import com.AISmartSafetyHelmetBE.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SafetyLingLockService {

    @Autowired
    private SafetyRingLockRepository safetyRingLockRepository;

    @Autowired
    private WorkerRepository workerRepository;

    public Boolean addAccident(SafetyLingLockRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        SafetyRingLock safetyRingLock = dto.toEntity(worker);
        safetyRingLockRepository.save(safetyRingLock);
        return true;
    }
}
