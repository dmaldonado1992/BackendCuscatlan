package com.bd.pdv.services;

import com.bd.pdv.dto.Product;

import java.util.List;

public interface IApiService {

    public List<Product> getProducts(Product product);
    public Product getProductsById(Product product);
    public Product callPts(Product product);
}
