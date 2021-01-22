package com.booking.service.impl;

import com.booking.dao.StadiumTicketRepository;
import com.booking.model.Customer;
import com.booking.model.Sector;
import com.booking.model.StadiumTicket;
import com.booking.service.CustomerService;
import com.booking.service.SectorService;
import com.booking.service.StadiumTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumTicketServiceImpl implements StadiumTicketService {

    @Autowired
    StadiumTicketRepository stadiumTicketRepository;

    @Autowired
    CustomerService customerService;
    @Autowired
    SectorService sectorService;

    @Override
    public Long create(Long customerId, Long sectorId) {
        StadiumTicket stadiumTicket = new StadiumTicket();
        Customer customer = customerService.findById(customerId);
        Sector sector = sectorService.findById(sectorId);
        stadiumTicket.setCustomer(customer);
        stadiumTicket.setSector(sector);
        return stadiumTicketRepository.save(stadiumTicket).getId();
    }
}
