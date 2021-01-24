package com.booking.resource;

import com.booking.model.SectorType;
import com.booking.service.SectorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SectorTypeResource {
    @Autowired
    SectorTypeService sectorTypeService;

    @GetMapping("/api/v1/sectors/types")
    public ResponseEntity<List<SectorType>> getAllSectorTypes() {
        return new ResponseEntity<>(sectorTypeService.getAllSectorTypes(), HttpStatus.OK);
    }
}
