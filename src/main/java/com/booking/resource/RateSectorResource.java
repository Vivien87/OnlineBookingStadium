package com.booking.resource;

import com.booking.exception.CommonException;
import com.booking.model.RateSector;
import com.booking.service.RateSectorService;
import com.booking.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class RateSectorResource {
    @Autowired
    private RateSectorService rateSectorService;
    @Autowired
    private SectorService sectorService;

    @GetMapping("/price/all")
    public ResponseEntity<List<RateSector>> getAllListWithPrice() {
        return new ResponseEntity<>(rateSectorService.getAllPrices(), HttpStatus.OK);
    }

}
