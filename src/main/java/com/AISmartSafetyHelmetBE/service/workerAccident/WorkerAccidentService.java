package com.AISmartSafetyHelmetBE.service.workerAccident;

import com.AISmartSafetyHelmetBE.dto.workerAccident.WorkerAccidentRequestDto;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerAccident;
import com.AISmartSafetyHelmetBE.repository.WorkerAccidentRepository;
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
public class WorkerAccidentService {

    @Autowired
    private WorkerAccidentRepository workerAccidentRepository;

    @Autowired
    private WorkerRepository workerRepository;
    public Boolean addAccident(WorkerAccidentRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        WorkerAccident workerAccident = dto.toEntity(worker);
        workerAccidentRepository.save(workerAccident);
        return true;
    }
}
