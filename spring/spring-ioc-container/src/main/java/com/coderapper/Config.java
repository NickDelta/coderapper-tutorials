package com.coderapper;

import com.coderapper.models.Booking;
import com.coderapper.models.Client;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class Config
{

    @Bean(name = "clientDB")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public List<Client> getClientDB()
    {
        System.out.println("Created a new Client list on " + LocalDateTime.now());
        return Collections.synchronizedList(new ArrayList<>());
    }

    @Bean(name = "bookingDB")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public List<Booking> getBookingDB()
    {
        System.out.println("Created a new Booking list on " + LocalDateTime.now());
        return Collections.synchronizedList(new ArrayList<>());
    }

}
