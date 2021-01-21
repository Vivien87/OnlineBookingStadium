package com.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rate")
@Getter
@Setter
@NoArgsConstructor
public class RateSector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long price;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, targetEntity = SectorType.class)
    @JoinColumn(name = "sector_type_id", referencedColumnName = "id")
    private SectorType sectorType;

}
