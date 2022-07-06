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
public class Street {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "city_street_fk"))
    private City city;
}
