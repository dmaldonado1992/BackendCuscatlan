package com.bd.pdv.services;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.models.entity.Product;

import java.util.List;

public interface IProductService {
    public CustomResponse<List<Product>> findAll();

    public CustomResponse<Product> save(Product product);
}
