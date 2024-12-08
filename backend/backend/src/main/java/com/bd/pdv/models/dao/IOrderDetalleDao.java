package com.bd.pdv.models.dao;

import com.bd.pdv.models.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IOrderDetalleDao extends CrudRepository<OrderDetail, Integer> {
    Optional<OrderDetail> findById(long id);
    Optional<OrderDetail> findAllBy();
}
