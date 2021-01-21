package com.booking.service.impl;

import com.booking.dao.SectorRepository;
import com.booking.model.Sector;
import com.booking.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();
        return sectors;
    }
}
