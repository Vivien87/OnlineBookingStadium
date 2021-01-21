package com.booking.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sector_type")
@NoArgsConstructor
@Getter
@Setter
public class SectorType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String type;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sectorType")
    private List<Sector> sector;

    @OneToOne(mappedBy = "sectorType", targetEntity = RateSector.class)
    private RateSector rateSector;

}
