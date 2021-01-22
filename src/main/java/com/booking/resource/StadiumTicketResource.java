package com.booking.resource;

import com.booking.exception.CommonException;
import com.booking.filter.SectorStadiumFilter;
import com.booking.service.SectorService;
import com.booking.service.StadiumTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class StadiumTicketResource {
    @Autowired
    private SectorService sectorService;

    @Autowired
    private StadiumTicketService stadiumTicketService;

    @PostMapping()
    public ResponseEntity<Long> reservatById(SectorStadiumFilter filter) {

        if(!sectorService.isAvailable(filter.getSectorId())){
            throw new CommonException("Sector by " + filter.getSectorId() + " is not available");
        }
        Long createdId = stadiumTicketService.create(filter);
        return new ResponseEntity<>(createdId, HttpStatus.OK);
    }
}
