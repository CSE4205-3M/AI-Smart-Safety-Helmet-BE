package com.AISmartSafetyHelmetBE.dto.commute;

import com.AISmartSafetyHelmetBE.entity.Commute;
import com.AISmartSafetyHelmetBE.entity.Worker;
import jdk.vm.ci.meta.Local;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class CommuteRequestDto {
    private UUID raspberryPiId;
    private int status;

    public Commute toEntity(Worker worker) {
        Commute commute = Commute.builder()
                .commute_id(UUID.randomUUID())
                .status(status)
                .date(LocalDateTime.now().format(DateTimeFormatter.ofPattern(("yyyy-MM-dd"))))
                .worker(worker)
                .build();
        return commute;
    }
}
