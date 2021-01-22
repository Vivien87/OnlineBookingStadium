package com.booking.service;

import com.booking.model.Sector;

import java.util.List;

public interface SectorService {

    List<Sector> getAllSectors();
    List<Sector> findAllFreePlace();
    Sector findById(Long id);
    void bookingSector(Long id);
    boolean isAvailable(Long id);
}
