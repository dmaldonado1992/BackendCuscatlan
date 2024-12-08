package com.bd.pdv.services.impl;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.dto.Product;
import com.bd.pdv.models.dao.IOrderDao;
import com.bd.pdv.models.dao.IOrderDetalleDao;
import com.bd.pdv.models.entity.Order;
import com.bd.pdv.models.entity.OrderDetail;
import com.bd.pdv.services.IOrderService;
import com.bd.pdv.utils.HttpRequestPdv;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Value("https://fakestoreapi.com/products/")
    private String urlApi;

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IOrderDetalleDao orderDetailDao;

    public HashMap<String,String> headers=new HashMap<String,String>();


    @Override
    public Optional<Order> findById(Long id) {

        Optional<Order> order = Optional.ofNullable(orderDao.findById(id));
        if (!order.isEmpty()){
            for (OrderDetail detail : order.get().getOrderDetail()) {

                headers.put("Content-Type","application/json; charset=UTF-8");
                com.bd.pdv.dto.Product respProd=(Product) HttpRequestPdv.get(urlApi + detail.getProductId(),null,headers);
                detail.setTitle(respProd.getTitle());
                detail.setDescription(respProd.getDescription());
                detail.setCategory(respProd.getCategory());
                detail.setImage(respProd.getImage());
                detail.setTotal((float) (respProd.getPrice()*detail.getQuantity()));
            }
        }
        return order;
    }

    public List<Order> findAll(){
        List<Order> orders = (List<Order>) orderDao.findAll();
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();

            for (OrderDetail detail : order.getOrderDetail()) {
                headers.put("Content-Type","application/json; charset=UTF-8");
                com.bd.pdv.dto.Product respProd=(Product) HttpRequestPdv.get(urlApi + detail.getProductId(),null,headers);
                detail.setTitle(respProd.getTitle());
                detail.setDescription(respProd.getDescription());
                detail.setCategory(respProd.getCategory());
                detail.setImage(respProd.getImage());
                detail.setTotal((float) (respProd.getPrice()*detail.getQuantity()));
                detail.setOrderId(order);
            }
        }
        return orders;
    }

    @Override
    public CustomResponse<Order> save(Order order) {
        CustomResponse<Order> resp = new CustomResponse();
        try {

            order.setTotal(0);
            order.setBalance(0);
            order = orderDao.save(order);


            if(order.getId() != null) {
                resp.setOk(true);
                resp.setData(order);

                for (OrderDetail detail : order.getOrderDetail()) {
                    detail.setOrderId(order);

                    com.bd.pdv.dto.Product respProd=(Product) HttpRequestPdv.get(urlApi + detail.getProductId(),null,headers);
                    detail.setTitle(respProd.getTitle());
                    detail.setDescription(respProd.getDescription());
                    detail.setCategory(respProd.getCategory());
                    detail.setImage(respProd.getImage());
                    detail.setTotal((float) (respProd.getPrice()*detail.getQuantity()));
                    detail = orderDetailDao.save(detail);
                    order.setTotal(order.getTotal()+detail.getTotal());
                    order.setBalance(order.getTotal());
                }

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
