package com.AISmartSafetyHelmetBE.dto.safetyLingLock;

import com.AISmartSafetyHelmetBE.entity.SafetyRingLock;
import com.AISmartSafetyHelmetBE.entity.Worker;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SafetyLingLockRequestDto {
    private String raspberryPiId;
    private float latitude;
    private float longitude;
    private char zone;

    public SafetyRingLock toEntity(Worker worker) {
        SafetyRingLock safetyRingLock = SafetyRingLock.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .zone(zone)
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"))))
                .build();
        return safetyRingLock;
    }
}
