package com.AISmartSafetyHelmetBE.service.workerAccident;

import com.AISmartSafetyHelmetBE.dto.workerAccident.WorkerAccidentRequestDto;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerAccident;
import com.AISmartSafetyHelmetBE.repository.WorkerAccidentRepository;
import com.AISmartSafetyHelmetBE.repository.WorkerRepository;
import com.AISmartSafetyHelmetBE.service.sms.SmsService;
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

    @Autowired
    private SmsService smsService;

    public Boolean addAccident(WorkerAccidentRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        smsService.sendSMS("근로자 " + worker.getName() + " 사고 발생\n 위치: " + dto.getValue() + "\n사고 내용: " + dto.getDescription());
        WorkerAccident workerAccident = dto.toEntity(worker);
        workerAccidentRepository.save(workerAccident);
        return true;
    }
}
