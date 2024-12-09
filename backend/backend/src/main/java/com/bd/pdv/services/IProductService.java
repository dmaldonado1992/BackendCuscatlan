package com.bd.pdv.services;

import com.bd.pdv.dto.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getProducts(Product product);
    public Product getProductsById(Product product);
}
