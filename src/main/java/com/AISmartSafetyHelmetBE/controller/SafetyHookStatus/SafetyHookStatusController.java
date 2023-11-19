package com.AISmartSafetyHelmetBE.controller.SafetyHookStatus;

import com.AISmartSafetyHelmetBE.dto.SafetyHookStatus.SafetyHookStatusRequestDto;
import com.AISmartSafetyHelmetBE.service.SafetyHookStatus.SafetyHookStatusService;
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
public class SafetyHookStatusController {

    @Autowired
    private SafetyHookStatusService safetyHookStatusService;

    @Operation(description = "안전 고리 체결 사고 데이터 전송")
    @PostMapping("/accident/safetyRing-unlocked")
    public ResponseEntity<Boolean> addAccident(@RequestBody SafetyHookStatusRequestDto dto) {

        return ResponseEntity.status(HttpStatus.OK).body(safetyHookStatusService.addAccident(dto));
    }
}
