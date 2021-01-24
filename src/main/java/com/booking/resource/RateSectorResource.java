package com.booking.resource;

import com.booking.model.RateSector;
import com.booking.service.RateSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RateSectorResource {
    @Autowired
    private RateSectorService rateSectorService;

    @GetMapping("/api/v1/price/all")
    public ResponseEntity<List<RateSector>> getAllListWithPrice() {
        return new ResponseEntity<>(rateSectorService.getAllPrices(), HttpStatus.OK);
    }

}
