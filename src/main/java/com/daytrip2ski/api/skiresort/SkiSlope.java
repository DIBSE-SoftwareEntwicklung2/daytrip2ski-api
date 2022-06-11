package com.daytrip2ski.api.skiresort;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class SkiSlope {
    @Id
    @SequenceGenerator(
            name = "ski_slope_id_seq",
            sequenceName = "ski_slope_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ski_slope_id_seq"
    )
    private Long id;
    private String name;
    private String length;
    private Long minAltitude;
    private Long maxAltitude;
    private String difficulty;
    private String snowCondition;
    private String description;
    private String remark;
    private Boolean temporarilyClosed;
    @ManyToOne
    @JoinColumn(
            name = "skiresort_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "skiresort_skislope_fk"
            )
    )
    Skiresort skiresort;
}
