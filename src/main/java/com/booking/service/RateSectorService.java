package com.booking.service;

import com.booking.model.RateSector;

import java.util.List;


public interface RateSectorService {
   List<RateSector> getAllPrices();

   Long create(Long id, Long sectorId);
}
