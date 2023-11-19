package com.AISmartSafetyHelmetBE.dto.workerAccident;

import com.AISmartSafetyHelmetBE.entity.Worker;
import com.AISmartSafetyHelmetBE.entity.WorkerAccident;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    private int value;
    private String description;

    public WorkerAccident toEntity(Worker worker) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        WorkerAccident workerAccident = WorkerAccident.builder()
                .worker(worker)
                .latitude(latitude)
                .longitude(longitude)
                .value(value)
                .timestamp(Timestamp.valueOf(sdf.format(new Timestamp(System.currentTimeMillis()))))
                .time_sec(System.currentTimeMillis())
                .description(description)
                .build();
        return workerAccident;

    }

}
