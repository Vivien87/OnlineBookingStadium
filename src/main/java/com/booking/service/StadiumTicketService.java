package com.booking.service;

import com.booking.filter.SectorFilter;
import com.booking.filter.SectorStadiumFilter;

public interface StadiumTicketService {
    Long create(SectorStadiumFilter filter);
}
