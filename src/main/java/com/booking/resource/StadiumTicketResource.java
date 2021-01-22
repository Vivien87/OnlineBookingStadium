package com.booking.resource;

import com.booking.exception.CommonException;
import com.booking.model.RateSector;
import com.booking.service.RateSectorService;
import com.booking.service.SectorService;
import com.booking.service.StadiumTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class StadiumTicketResource {
    @Autowired
    private SectorService sectorService;

    @Autowired
    private StadiumTicketService stadiumTicketService;

    @PostMapping("/{sectorId}/customer/{id}")
    public ResponseEntity<Long> bookedBySectorId(@PathVariable Long sectorId, @PathVariable Long id) {
        if(!sectorService.isAvailable(sectorId)){
            throw new CommonException("Sector by " + sectorId + " is not available");
        }
        Long createdId = stadiumTicketService.create(id, sectorId);
        return new ResponseEntity<>(createdId, HttpStatus.OK);
    }

//    @PostMapping("/{sectorId}/customer/{id}")
//    public ResponseEntity<Long> bookedBySectorId(@PathVariable Long sectorId, @PathVariable Long id) {
//        if(!sectorService.isAvailable(sectorId)){
//            throw new CommonException("Sector by " + sectorId + " is not available");
//        }
//        Long createdId = stadiumTicketService.create(id, sectorId);
//        return new ResponseEntity<>(createdId, HttpStatus.OK);
//    }
}
