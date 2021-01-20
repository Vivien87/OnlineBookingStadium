package com.booking.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


@Table(name = "sectors")
@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int seatNumber;
    private int rowNumber;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sector_type_id", referencedColumnName = "id")
    private SectorType sectorType;
    private boolean isBooked;
    @OneToMany(mappedBy="sectorTypes", targetEntity = PriceEntity.class)
    private List<PriceEntity> priceEntity = new ArrayList<>();
}
