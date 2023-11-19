package com.AISmartSafetyHelmetBE.dto.SafetyRingLock;

import com.AISmartSafetyHelmetBE.entity.SafetyRingLock;
import com.AISmartSafetyHelmetBE.entity.Worker;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SafetyRingLockRequestDto {
    private String raspberryPiId;
    private float latitude;
    private float longitude;
    private int status;
    private int zone;

    public SafetyRingLock toEntity(Worker worker) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SafetyRingLock safetyRingLock = SafetyRingLock.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .zone(zone)
                .time_sec(System.currentTimeMillis())
                .status(status)
                .tmp("tmp")
                .timestamp(Timestamp.valueOf(sdf.format(new Timestamp(System.currentTimeMillis()))))
                .build();
        return safetyRingLock;
    }
}
