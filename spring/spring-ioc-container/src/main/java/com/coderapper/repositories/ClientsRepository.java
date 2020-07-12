package com.coderapper.repositories;

import com.coderapper.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ClientsRepository implements CrudRepository<Client,Integer>
{
    private List<Client> clientDB;

    @Override
    public List<Client> findAll()
    {
        return Collections.unmodifiableList(clientDB);
    }

    @Override
    public Optional<Client> findById(Integer id)
    {
        Objects.requireNonNull(id);
        return  clientDB.stream()
                .filter(x-> x.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Client client)
    {
        Objects.requireNonNull(client);
        clientDB.add(client);
    }

    @Override
    public void update(Client client)
    {
        Objects.requireNonNull(client);
        clientDB.set(clientDB.indexOf(client),client);
    }

    @Override
    public void delete(Client client)
    {
        Objects.requireNonNull(client);
        clientDB.remove(client);
    }

    @Autowired
    @Qualifier("clientDB")
    public void setClientDB(List<Client> clientDB)
    {
        this.clientDB = clientDB;
    }
}