package com.bd.pdv.services;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.models.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClientService {
    public List<Client> findAll();
    public CustomResponse<Client> findById(int id);
    public CustomResponse<Client> save(Client partner);
    public CustomResponse delete(int id);
}
