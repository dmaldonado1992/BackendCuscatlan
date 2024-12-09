package com.bd.pdv.services;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.models.entity.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    public Optional<Order> findById(Long id);
    public List<Order> findAll();
    public CustomResponse<Order> save(Order order);
    public CustomResponse<Order> applyPay(Order order);

}
