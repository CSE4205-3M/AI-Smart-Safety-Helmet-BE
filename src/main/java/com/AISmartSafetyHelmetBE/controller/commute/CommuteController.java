package com.AISmartSafetyHelmetBE.controller.commute;

import com.AISmartSafetyHelmetBE.dto.commute.CommuteRequestDto;
import com.AISmartSafetyHelmetBE.repository.CommuteRepository;
import com.AISmartSafetyHelmetBE.service.commute.CommuteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:8080")
public class CommuteController {

    @Autowired
    private CommuteRepository commuteRepository;

    @Autowired
    private CommuteService commuteService;

    @Operation(description = "근로자의 출근 여부 데이터 전송")
    @PostMapping("/commute")
    public ResponseEntity<Boolean> addCommute(@RequestBody CommuteRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(commuteService.addCommute(dto));
    }


}
