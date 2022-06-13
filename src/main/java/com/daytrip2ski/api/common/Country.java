package com.daytrip2ski.api.common;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Country {
    @Id
    @SequenceGenerator(
            name = "country_seq",
            sequenceName = "country_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_seq"
    )
    private Long id;
    private String code3;
    private String code2;
    private String continent;
    private String region;
    private String capital;
}
