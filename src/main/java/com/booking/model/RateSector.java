package com.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rate")
@Data
@NoArgsConstructor
public class RateSector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long price;

    @OneToOne(fetch = FetchType.LAZY, optional = false, targetEntity = SectorType.class)
    private SectorType sectorType;

}
