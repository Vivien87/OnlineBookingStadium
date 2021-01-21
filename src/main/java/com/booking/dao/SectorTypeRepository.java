package com.booking.dao;

import com.booking.model.SectorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorTypeRepository extends JpaRepository<SectorType, Long> {
}
