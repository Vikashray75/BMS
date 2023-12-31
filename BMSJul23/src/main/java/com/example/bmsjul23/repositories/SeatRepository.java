package com.example.bmsjul23.repositories;

import com.example.bmsjul23.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
   // @Override
    List<Seat> findAllByIdIn(List<Integer> seatIds);
}
