package com.AISmartSafetyHelmetBE.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "worker_id")
    private UUID workerId;

    @Column(name = "raspberry_pi_id")
    private String raspberryPiId;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name ="emergency_phone_number")
    private String emergencyPhoneNumber;

    @Column(name = "health_issue")
    private String healthIssue;
}


