package com.booking.service;

import com.booking.filter.SectorFilter;
import com.booking.model.Sector;

import java.util.List;

public interface SectorService {

    List<Sector> getAllSectors();
    List<Sector> findAllFreePlace();
    Sector findById(Long id);
    void setBooked(Long id);
    boolean isAvailable(Long id);

    Sector find(SectorFilter filter);
}
