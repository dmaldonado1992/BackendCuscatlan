package com.bd.pdv.services.impl;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.models.dao.IOrderDao;
import com.bd.pdv.models.entity.Order;
import com.bd.pdv.models.entity.Product;
import com.bd.pdv.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public Optional<Order> findById(Long id) {
        return orderDao.findById(id);
    }

    public List<Order> findAll(){
        List<Order> orders = (List<Order>) orderDao.findAll();
        return orders;
    }

    @Override
    public CustomResponse<Order> save(Order order) {
        CustomResponse<Order> resp = new CustomResponse();
        try {
            order = orderDao.save(order);
            if(order.getId() != null) {
                resp.setOk(true);
                resp.setData(order);
            }else {
                resp.setOk(false);
                resp.setMessage("Se ha producido un error al guardar.");
                resp.setData(order);
            }
        }catch (Exception e) {
            resp.setOk(false);
            resp.setMessage(e.getMessage());
        }
        return resp;
    }

}
