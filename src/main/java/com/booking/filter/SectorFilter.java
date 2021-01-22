package com.booking.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SectorFilter {

    private Long id;
    private Long sectorId;
    private Long customerId;
    private int seatNumber;
    private int rowNumber;


}
