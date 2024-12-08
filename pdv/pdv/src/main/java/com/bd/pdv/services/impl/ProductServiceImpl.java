package com.bd.pdv.services.impl;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.models.dao.IProductDao;
import com.bd.pdv.models.entity.Product;
import com.bd.pdv.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public CustomResponse<List<Product>> findAll() {
        List<Product> list = new ArrayList<Product>();
        Iterable<Product> resp = productDao.findAll();
        resp.forEach(list::add);

        CustomResponse result = new CustomResponse(list);

        return result;
    }

    @Override
    public CustomResponse<Product> save(Product product) {
        CustomResponse<Product> resp = new CustomResponse();
        try {
            product = productDao.save(product);
            if(product.getId() != null) {
                resp.setOk(true);
                resp.setData(product);
            }else {
                resp.setOk(false);
                resp.setMessage("Se ha producido un error al guardar.");
                resp.setData(product);
            }
        }catch (Exception e) {
            resp.setOk(false);
            resp.setMessage(e.getMessage());
        }
        return resp;
    }
}
