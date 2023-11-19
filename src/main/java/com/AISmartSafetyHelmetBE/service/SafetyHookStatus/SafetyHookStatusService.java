package com.AISmartSafetyHelmetBE.service.SafetyHookStatus;


import com.AISmartSafetyHelmetBE.dto.SafetyHookStatus.SafetyHookStatusRequestDto;
import com.AISmartSafetyHelmetBE.entity.SafetyHookStatus;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.repository.SafetyHookStatusRepository;
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
public class SafetyHookStatusService {

    @Autowired
    private SafetyHookStatusRepository safetyHookStatusRepository;

    @Autowired
    private WorkerRepository workerRepository;

    public Boolean addAccident(SafetyHookStatusRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        SafetyHookStatus safetyHookStatus = dto.toEntity(worker);
        safetyHookStatusRepository.save(safetyHookStatus);
        return true;
    }
}
