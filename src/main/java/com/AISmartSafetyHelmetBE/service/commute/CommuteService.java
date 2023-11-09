package com.AISmartSafetyHelmetBE.service.commute;

import com.AISmartSafetyHelmetBE.dto.commute.CommuteRequestDto;
import com.AISmartSafetyHelmetBE.entity.Commute;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerFall;
import com.AISmartSafetyHelmetBE.repository.CommuteRepository;
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
public class CommuteService {

    @Autowired
    private CommuteRepository commuteRepository;

    @Autowired
    private WorkerRepository workerRepository;
    public Boolean addCommute(CommuteRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        Commute commute = dto.toEntity(worker);
        commuteRepository.save(commute);
        return true;

    }
}
