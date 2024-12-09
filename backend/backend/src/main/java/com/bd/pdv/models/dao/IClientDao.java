package com.bd.pdv.models.dao;

import com.bd.pdv.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientDao extends CrudRepository<Client, Integer> {
}
