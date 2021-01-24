package com.booking.service.impl;

import com.booking.dao.StadiumTicketRepository;
import com.booking.exception.CommonException;
import com.booking.filter.SectorFilter;
import com.booking.filter.SectorStadiumFilter;
import com.booking.model.Customer;
import com.booking.model.Sector;
import com.booking.model.StadiumTicket;
import com.booking.service.CustomerService;
import com.booking.service.SectorService;
import com.booking.service.StadiumTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StadiumTicketServiceImpl implements StadiumTicketService {

    @Autowired
    StadiumTicketRepository stadiumTicketRepository;

    @Autowired
    CustomerService customerService;
    @Autowired
    SectorService sectorService;

    @Override
    @Transactional
    public Long create(SectorStadiumFilter filter) {
        Customer customer = customerService.findById(filter.getCustomerId());
        SectorFilter sectorFilter = new SectorFilter();
        sectorFilter.setId(filter.getSectorId());
        sectorFilter.setRowNumber(filter.getRowNumber());
        sectorFilter.setSeatNumber(filter.getSeatNumber());
        Sector sector = sectorService.find(sectorFilter);
        StadiumTicket stadiumTicket = new StadiumTicket();
        stadiumTicket.setCustomer(customer);
        stadiumTicket.setSector(sector);
        Long createdId = stadiumTicketRepository.save(stadiumTicket).getId();
        if (createdId < 0) {
            throw new CommonException("cannot insert db");
        }
        sectorService.setBooked(filter.getSectorId());
        return createdId;
    }
}
