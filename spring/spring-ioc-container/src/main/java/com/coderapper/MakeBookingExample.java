package com.coderapper;

import com.coderapper.models.Client;
import com.coderapper.repositories.BookingsRepository;
import com.coderapper.repositories.ClientsRepository;

import com.coderapper.services.BookingsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MakeBookingExample
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.coderapper");

        ClientsRepository clientsRepository = context.getBean(ClientsRepository.class);
        clientsRepository.save(new Client("Code","Rapper",19));
        System.out.println("Clients DB Contents: " + clientsRepository.findAll());

        BookingsService bookingsService = context.getBean(BookingsService.class);
        bookingsService.makeBooking(1,"Super Hotel",5);

        BookingsRepository bookingsRepository = context.getBean(BookingsRepository.class);
        System.out.println("Bookings DB Contents: " + bookingsRepository.findAll());
    }
}
