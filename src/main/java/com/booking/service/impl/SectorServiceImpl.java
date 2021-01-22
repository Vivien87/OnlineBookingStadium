package com.booking.service.impl;

import com.booking.dao.SectorRepository;
import com.booking.exception.CommonException;
import com.booking.filter.SectorFilter;
import com.booking.model.Sector;
import com.booking.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();
        return CollectionUtils.isEmpty(sectors) ? new ArrayList<>() : sectors;
    }

    @Override
    public List<Sector> findAllFreePlace() {
        List<Sector> freeSectors = sectorRepository.findAllFreePlace();
        return CollectionUtils.isEmpty(freeSectors) ? new ArrayList<>() : freeSectors;
    }

    @Override
    public boolean isAvailable(Long id) {
        return sectorRepository.isAvailable(id);
    }

    @Override
    public Sector findById(Long id) {
        Optional<Sector> sector = sectorRepository.findById(id);
        if (!sector.isPresent()) {
            throw new CommonException("not found sector id by " + id);
        }
        return sector.get();
    }

    @Override
    public Sector find(SectorFilter filter) {
        if (filter == null || filter.getId() == null || filter.getSeatNumber() < 0 || filter.getSeatNumber() < 0) {
            throw new CommonException("filter is empty");
        }
        Optional<Sector> sector;
        if (filter.getId() != null) {
            sector = sectorRepository.findById(filter.getId());
        } else {
            sector = sectorRepository.findByRowAndSeatNumber(filter.getRowNumber(), filter.getSeatNumber());
        }
        if (sector.isPresent()) {
            return sector.get();
        }
        throw new CommonException("can not find sector");
    }

    @Override
    public void setBooked(Long id) {
        sectorRepository.setBookedById(id);
    }
}
