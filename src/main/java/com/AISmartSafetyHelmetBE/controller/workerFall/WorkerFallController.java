package com.AISmartSafetyHelmetBE.controller.workerFall;

import com.AISmartSafetyHelmetBE.dto.workerFall.WorkerFallRequestDto;
import com.AISmartSafetyHelmetBE.service.workerFall.WorkerFallService;
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
public class WorkerFallController {

    @Autowired
    private WorkerFallService workerFallService;

    @Operation(description = "근로자의 쓰러짐 감지 데이터 전송")
    @PostMapping("/accident/workerFall")
    public ResponseEntity<Boolean> addAccident(@RequestBody WorkerFallRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(workerFallService.addAccident(dto));
    }
}
