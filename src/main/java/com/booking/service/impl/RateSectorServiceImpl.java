package com.booking.service.impl;

import com.booking.dao.RateSectorRepository;
import com.booking.model.RateSector;
import com.booking.service.RateSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateSectorServiceImpl implements RateSectorService {
    @Autowired
    private RateSectorRepository rateSectorRepository;

    @Override
    public List<RateSector> getAllPrices() {
        return rateSectorRepository.findAll();
    }

    @Override
    public Long create(Long id, Long sectorId) {
        RateSector rate = new RateSector();
        return rateSectorRepository.save(rate).getId();
    }
}
