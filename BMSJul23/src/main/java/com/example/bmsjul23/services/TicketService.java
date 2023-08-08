package com.example.bmsjul23.services;

import com.example.bmsjul23.models.*;
import com.example.bmsjul23.repositories.SeatRepository;
import com.example.bmsjul23.repositories.ShowRepository;
import com.example.bmsjul23.repositories.ShowSeatRepository;
import com.example.bmsjul23.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TicketService {
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, SeatRepository seatRepository, TicketRepository ticketRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(int showId, List<Integer>seatIds, int userId)throws Exception
    {
        Optional<Show> showoptional = showRepository.findById(showId);

        if (!showoptional.isEmpty())
        {
            throw new Exception("show does not exist");
        }

       // List<Seat> seats = seatRepository.findAllByIds(seatIds);
        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);

        if(seats.size() !=seatIds.size())
        {
            throw new Exception("Invalid seats");
        }

        Show show = showoptional.get();

        //List<ShowSeat> showSeats= showSeatRepository.findShowSeatsByShowAndSeats(show,seats);
        List<ShowSeat> showSeats = showSeatRepository.findShowSeatByShow(show);
        for (ShowSeat showSeat : showSeats) {
            if(!showSeat.getStatus().equals(SeatStatus.AVAILABLE)) {
                throw new Exception("Seat not available");
            }

        }

        Ticket ticket=new Ticket();
        ticket.setSeats(seats);
        ticket.setShow(show);
        ticket.setTimeOfBoking(new Date());
        return ticketRepository.save(ticket);


    }
}
