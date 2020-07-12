package com.coderapper.repositories;

import com.coderapper.models.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class BookingsRepository implements CrudRepository<Booking,Integer>
{
    private List<Booking> bookingDB;

    @Override
    public List<Booking> findAll()
    {
        return Collections.unmodifiableList(bookingDB);
    }

    @Override
    public Optional<Booking> findById(Integer id)
    {
        Objects.requireNonNull(id);
        return  bookingDB.stream()
                .filter(x-> x.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Booking booking)
    {
        Objects.requireNonNull(booking);
        bookingDB.add(booking);
    }

    @Override
    public void update(Booking booking)
    {
        Objects.requireNonNull(booking);
        bookingDB.set(bookingDB.indexOf(booking),booking);
    }

    @Override
    public void delete(Booking booking)
    {
        Objects.requireNonNull(booking);
        bookingDB.remove(booking);
    }

    @Autowired
    @Qualifier("bookingDB")
    public void setBookingDB(List<Booking> bookingDB)
    {
        this.bookingDB = bookingDB;
    }
}