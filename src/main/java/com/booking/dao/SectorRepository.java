package com.booking.dao;

import com.booking.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    @Query("select s from Sector s where s.isBooked=false ")
    List<Sector> findAllFreePlace();

    @Query("select case when count(s) > 0 then true else false end from Sector s where s.isBooked=false and s.id = (:id)")
    boolean isAvailable(Long id);

    @Query("select s from Sector s where s.isBooked=false and s.rowNumber = (:rowNumber) and s.seatNumber = (:seatNumber)")
    Optional<Sector> findByRowAndSeatNumber(int rowNumber, int seatNumber);

    @Modifying
    @Query("update Sector s set s.isBooked = true  where s.id=:id")
    void setBookedById(Long id);
}
