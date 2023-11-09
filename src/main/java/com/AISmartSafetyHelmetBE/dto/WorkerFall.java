package com.AISmartSafetyHelmetBE.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.UUID;

@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "worker_fall")
public class WorkerFall {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "accident_id")
    private UUID accident_id;

    @ManyToOne
    @JoinColumn(name="worker_id")
    private Worker worker;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @Column(name="zone")
    private char zone;
}
