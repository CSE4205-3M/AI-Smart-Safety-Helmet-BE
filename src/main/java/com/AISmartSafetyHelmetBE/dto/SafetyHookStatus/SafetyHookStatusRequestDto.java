package com.AISmartSafetyHelmetBE.dto.SafetyHookStatus;

import com.AISmartSafetyHelmetBE.entity.SafetyHookStatus;
import com.AISmartSafetyHelmetBE.entity.Worker;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class SafetyHookStatusRequestDto {
    private String raspberryPiId;
    private float latitude;
    private float longitude;
    private int check;
    private char zone;

    public SafetyHookStatus toEntity(Worker worker) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SafetyHookStatus safetyHookStatus = SafetyHookStatus.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .zone(zone)
                .time_sec(System.currentTimeMillis())
                .check(check)
                .tmp("tmp")
                .timestamp(Timestamp.valueOf(sdf.format(new Timestamp(System.currentTimeMillis()))))
                .build();
        return safetyHookStatus;
    }
}
