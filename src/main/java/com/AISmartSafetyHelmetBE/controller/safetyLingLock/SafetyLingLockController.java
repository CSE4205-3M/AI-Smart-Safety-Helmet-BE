package com.AISmartSafetyHelmetBE.controller.safetyLingLock;

import com.AISmartSafetyHelmetBE.dto.safetyLingLock.SafetyLingLockRequestDto;
import com.AISmartSafetyHelmetBE.service.safetyLingLock.SafetyLingLockService;
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
public class SafetyLingLockController {

    @Autowired
    private SafetyLingLockService safetyLingLockService;

    @Operation(description = "안전 고리 체결 사고 데이터 전송")
    @PostMapping("/accident/safetyRing-unlocked")
    public ResponseEntity<Boolean> addAccident(@RequestBody SafetyLingLockRequestDto dto) {

        return ResponseEntity.status(HttpStatus.OK).body(safetyLingLockService.addAccident(dto));
    }
}
