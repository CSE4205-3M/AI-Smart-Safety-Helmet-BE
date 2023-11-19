package com.AISmartSafetyHelmetBE.dto.safetyLingLock;

import com.AISmartSafetyHelmetBE.entity.SafetyRingLock;
import com.AISmartSafetyHelmetBE.entity.Worker;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SafetyRingLock safetyRingLock = SafetyRingLock.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .zone(zone)
                .time_sec(System.currentTimeMillis())
                .timestamp(Timestamp.valueOf(sdf.format(new Timestamp(System.currentTimeMillis()))))
                .build();
        return safetyRingLock;
    }
}
