package com.AISmartSafetyHelmetBE.dto.workerFall;

import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerFall;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class WorkerFallRequestDto {
    private UUID raspberryPiId;
    private float latitude;
    private float longitude;
    private char zone;

    public WorkerFall toEntity(Worker worker) {
        WorkerFall workerFall = WorkerFall.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .zone(zone)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"))))
                .build();
        return workerFall;

    }

}
