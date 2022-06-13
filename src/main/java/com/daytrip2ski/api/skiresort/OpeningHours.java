package com.daytrip2ski.api.skiresort;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class OpeningHours {
    @Id
    @SequenceGenerator(
            name = "opening_hours_seq",
            sequenceName = "opening_hours_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "opening_hours_seq"
    )
    private Long id;
    private String season;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private Boolean temporarilyClosed;
    private String closedReason;
    @ManyToOne
    @JoinColumn(
            name = "skiresort_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "skiresort_openinghrs_fk"
            )
    )
    Skiresort skiresort;
}
