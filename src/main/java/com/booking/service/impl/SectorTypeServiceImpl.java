package com.booking.service.impl;

import com.booking.dao.SectorTypeRepository;
import com.booking.model.SectorType;
import com.booking.service.SectorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorTypeServiceImpl implements SectorTypeService {
    @Autowired
    SectorTypeRepository sectorTypeRepository;

    @Override
    public List<SectorType> getAllSectorTypes() {
        List<SectorType> sectorTypes = sectorTypeRepository.findAll();
        return sectorTypes;
    }
}
