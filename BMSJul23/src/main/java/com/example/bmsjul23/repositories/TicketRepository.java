package com.example.bmsjul23.repositories;

import com.example.bmsjul23.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    Ticket save(Ticket ticket);

}
