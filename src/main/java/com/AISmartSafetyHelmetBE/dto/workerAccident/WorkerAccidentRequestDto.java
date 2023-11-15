package com.AISmartSafetyHelmetBE.dto.workerAccident;

import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerAccident;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class WorkerAccidentRequestDto {
    private String raspberryPiId;
    private float latitude;
    private float longitude;
    private char zone;
    private String description;

    public WorkerAccident toEntity(Worker worker) {
        WorkerAccident workerAccident = WorkerAccident.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .zone(zone)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"))))
                .description(description)
                .build();
        return workerAccident;

    }

}
