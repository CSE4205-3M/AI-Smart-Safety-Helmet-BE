package com.AISmartSafetyHelmetBE.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "worker_Accident")
public class WorkerAccident {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "accident_id")
    private UUID accident_id;

    @ManyToOne
    @JoinColumn(name="worker_id")
    private Worker worker;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @Column(name="value")
    private int value;

    @Column(name="time_sec")
    private long time_sec;

    @Column(name="description")
    private String description;
}
