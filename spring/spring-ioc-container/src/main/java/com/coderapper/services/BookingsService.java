package com.coderapper.services;

import com.coderapper.models.Booking;
import com.coderapper.models.Client;
import com.coderapper.repositories.BookingsRepository;
import com.coderapper.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingsService
{
    private ClientsRepository clientsRepository;
    private BookingsRepository bookingsRepository;

    public void makeBooking(int clientID, String hotelName, int nights)
    {
        Optional<Client> client = clientsRepository.findById(clientID);

        if(client.isPresent())
            bookingsRepository.save(new Booking(client.get(),hotelName,nights));
        else
            System.err.println("Error: Client with ID: "+ clientID + " does not exist");
    }

    @Autowired
    public void setClientsRepository(ClientsRepository clientsRepository)
    {
        this.clientsRepository = clientsRepository;
    }

    @Autowired
    public void setBookingsRepository(BookingsRepository bookingsRepository)
    {
        this.bookingsRepository = bookingsRepository;
    }
}
