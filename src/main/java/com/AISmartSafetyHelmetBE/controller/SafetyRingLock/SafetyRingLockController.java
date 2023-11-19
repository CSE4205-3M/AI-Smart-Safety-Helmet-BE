package com.AISmartSafetyHelmetBE.controller.SafetyRingLock;

import com.AISmartSafetyHelmetBE.dto.SafetyRingLock.SafetyRingLockRequestDto;
import com.AISmartSafetyHelmetBE.service.SafetyRingLock.SafetyRingLockService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SafetyRingLockController {

    @Autowired
    private SafetyRingLockService safetyRingLockService;

    @Operation(description = "안전 고리 체결 사고 데이터 전송")
    @PostMapping("/accident/safetyRing-unlocked")
    public ResponseEntity<Boolean> addAccident(@RequestBody SafetyRingLockRequestDto dto) {

        return ResponseEntity.status(HttpStatus.OK).body(safetyRingLockService.addAccident(dto));
    }
}
