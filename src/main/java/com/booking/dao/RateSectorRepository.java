package com.booking.dao;

import com.booking.model.RateSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateSectorRepository extends JpaRepository<RateSector,Long> {
}
