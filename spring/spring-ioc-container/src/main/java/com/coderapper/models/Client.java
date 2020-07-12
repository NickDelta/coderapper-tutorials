package com.coderapper.models;

import java.util.Objects;

public class Client
{
    private final Integer id;
    private String name;
    private String surname;
    private Integer age;

    private static int idCounter = 1;

    public Client(String name, String surname, Integer age)
    {
        this.id = idCounter++; //Automatically assign id. Faking auto-incremental in DBs
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSurname()
    {
        return surname;
    }
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
