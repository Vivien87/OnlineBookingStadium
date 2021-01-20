package com.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prices")
@Data
@NoArgsConstructor
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = SectorType.class)
    private List<SectorType> sectorTypes = new ArrayList<>();
}
