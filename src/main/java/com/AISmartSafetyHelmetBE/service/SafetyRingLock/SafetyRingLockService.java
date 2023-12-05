package com.AISmartSafetyHelmetBE.service.SafetyRingLock;


import com.AISmartSafetyHelmetBE.dto.SafetyRingLock.SafetyRingLockRequestDto;
import com.AISmartSafetyHelmetBE.entity.SafetyRingLock;
import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.repository.SafetyRingLockRepository;
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
public class SafetyRingLockService {

    @Autowired
    private SafetyRingLockRepository safetyRingLockRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private SmsService smsService;
    public Boolean addAccident(SafetyRingLockRequestDto dto) {
        Worker worker = workerRepository.findByRaspberryPiId(dto.getRaspberryPiId());
        SafetyRingLock safetyRingLock = dto.toEntity(worker);
        smsService.sendSMS("근로자 " + worker.getName() + " 사고 발생\n 위치: " + dto.getValue() + "\n사고 내용: 안전고리 미체결");

        safetyRingLockRepository.save(safetyRingLock);
        return true;
    }
}
