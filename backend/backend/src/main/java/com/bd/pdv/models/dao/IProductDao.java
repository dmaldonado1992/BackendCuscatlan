package com.bd.pdv.models.dao;

import com.bd.pdv.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Integer> {
}
