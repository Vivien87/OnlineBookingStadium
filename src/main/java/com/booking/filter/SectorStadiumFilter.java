package com.booking.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SectorStadiumFilter {

    private Long id;
    private Long customerId;
    private Long sectorId;
    private int seatNumber;
    private int rowNumber;
}
