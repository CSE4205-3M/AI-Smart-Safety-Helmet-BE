package com.AISmartSafetyHelmetBE.service.workerFall;

import com.AISmartSafetyHelmetBE.dto.workerFall.WorkerFallRequestDto;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerFall;
import com.AISmartSafetyHelmetBE.repository.WorkerFallRepository;
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
public class WorkerFallService {

    @Autowired
    private WorkerFallRepository workerFallRepository;

    @Autowired
    private WorkerRepository workerRepository;
    public Boolean addAccident(WorkerFallRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        WorkerFall workerFall = dto.toEntity(worker);
        workerFallRepository.save(workerFall);
        return true;
    }
}
