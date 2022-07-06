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
public class City {
    @Id
    @SequenceGenerator(name = "city_seq", sequenceName = "city_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "country_city_fk"))
    private Country country;
    private String zipCode;
    private String name;
    private String district;
}
