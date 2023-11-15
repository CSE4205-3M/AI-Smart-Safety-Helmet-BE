package com.AISmartSafetyHelmetBE.controller.workerAccident;

import com.AISmartSafetyHelmetBE.dto.workerAccident.WorkerAccidentRequestDto;
import com.AISmartSafetyHelmetBE.service.workerAccident.WorkerAccidentService;
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
public class WorkerAccidentController {

    @Autowired
    private WorkerAccidentService workerAccidentService;

    @Operation(description = "근로자의 쓰러짐 감지 데이터 전송")
    @PostMapping("/accident/workerFall")
    public ResponseEntity<Boolean> addAccident(@RequestBody WorkerAccidentRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(workerAccidentService.addAccident(dto));
    }
}
