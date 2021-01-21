package com.booking.service;

import com.booking.model.RateSector;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RateSectorService {
   List<RateSector> getAllPrices();
}
