package com.example.bmsjul23.repositories;

import com.example.bmsjul23.models.Seat;
import com.example.bmsjul23.models.Show;
import com.example.bmsjul23.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
    //select * from show_seats where show_id=(show_id) and seat_id in {seat_ids}

    @Lock(value = LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findShowSeatByShow(Show show);
   // List<ShowSeat> findShowSeatsByShowAndSeat(Show show,List<Seat> seats);
  //List<ShowSeat> findShowSeatbyShowAndSeatIds(Show show,List<Integer> seatIds);

}
