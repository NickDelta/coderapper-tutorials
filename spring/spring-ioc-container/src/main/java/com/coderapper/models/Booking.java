package com.coderapper.models;

import java.util.Objects;

public class Booking
{
    private final Integer id;
    private Client client;
    private String hotel;
    private Integer nights;

    private static int idCounter = 1;

    public Booking(Client client, String hotel, Integer nights)
    {
        this.id = idCounter++;
        this.client = client;
        this.hotel = hotel;
        this.nights = nights;
    }

    public Integer getId()
    {
        return id;
    }
    public Client getClient()
    {
        return client;
    }
    public void setClient(Client client)
    {
        this.client = client;
    }
    public String getHotel()
    {
        return hotel;
    }
    public void setHotel(String hotel)
    {
        this.hotel = hotel;
    }
    public Integer getNights()
    {
        return nights;
    }
    public void setNights(Integer nights)
    {
        this.nights = nights;
    }


    @Override
    public String toString()
    {
        return "Booking{" +
                "id=" + id +
                ", client=" + client +
                ", hotel='" + hotel + '\'' +
                ", nights=" + nights +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
