package com.bd.pdv.models.dao;

import com.bd.pdv.models.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IOrderDao extends CrudRepository<Order, Integer> {
    Order findById(long id);
    Order findAllBy();
}
