package com.AISmartSafetyHelmetBE.dto;

import lombok.*;
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
@Table(name = "commute")
public class Commute {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "commute_id")
    private UUID commute_id;

    @ManyToOne
    @JoinColumn(name="worker_id")
    private Worker worker;

    @Column(name = "date")
    private String date;

    private int status;
}
