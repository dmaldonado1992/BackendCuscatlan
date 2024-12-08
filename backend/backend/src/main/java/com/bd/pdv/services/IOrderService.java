package com.bd.pdv.services;

import com.bd.pdv.models.entity.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    public Optional<Order> findById(Long id);
    public  List<Order> findAll();

}
