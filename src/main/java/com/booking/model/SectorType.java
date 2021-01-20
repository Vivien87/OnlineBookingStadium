package com.booking.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "sectorType", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Sector sector;
}
