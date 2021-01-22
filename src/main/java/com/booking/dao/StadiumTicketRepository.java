package com.booking.dao;


import com.booking.model.StadiumTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumTicketRepository extends JpaRepository<StadiumTicket,Long> {
}
