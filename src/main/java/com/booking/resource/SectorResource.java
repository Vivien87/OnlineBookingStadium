package com.booking.resource;

import com.booking.model.Sector;
import com.booking.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SectorResource {
    @Autowired
    private SectorService sectorService;

    @GetMapping("/api/v1/sectors/{id}")
    public Sector getSectorById(@PathVariable Long id) {
        return sectorService.findById(id);
    }

    @GetMapping("/api/v1/sectors")
    public ResponseEntity<List<Sector>> getAllSector() {
        return new ResponseEntity<>(sectorService.getAllSectors(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/sectors/available")
    public ResponseEntity<List<Sector>> findFreePlace() {
        return new ResponseEntity<>(sectorService.findAllFreePlace(), HttpStatus.OK);
    }


    @GetMapping("/api/v1/sectors/{id}/available")
    public boolean isAvailableById(@PathVariable Long id) {
        return sectorService.isAvailable(id);
    }
}
