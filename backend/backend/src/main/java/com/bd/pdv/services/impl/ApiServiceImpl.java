package com.bd.pdv.services.impl;

import com.bd.pdv.dto.Product;
import com.bd.pdv.services.IApiService;
import com.bd.pdv.utils.HttpRequestPdv;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ApiServiceImpl implements IApiService {


    @Value("https://fakestoreapi.com/products/")
    private String urlApi;


    @Override
    public List<Product> getProducts(Product product) {
        System.out.println("Products");
        HashMap<String,String> headers=new HashMap<String,String>();
        headers.put("Content-Type","application/json; charset=UTF-8");
        // headers.put("Authorization",token);

        ObjectMapper mapper = new ObjectMapper();
        String responseJson = null;
        try {
            responseJson = mapper.writeValueAsString(product);
            //Se desactiva transaction porque no se utiliza en la peticion
            responseJson = responseJson.replace("Transaction","TransactionDisabled");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<Product> resp=(List<Product>) HttpRequestPdv.getList(urlApi ,responseJson,headers);

        return resp;

    }

    @Override
    public Product getProductsById(Product product) {
        System.out.println("Products");
        HashMap<String,String> headers=new HashMap<String,String>();
        headers.put("Content-Type","application/json; charset=UTF-8");
       // headers.put("Authorization",token);

        ObjectMapper mapper = new ObjectMapper();
        String responseJson = null;
        try {
            responseJson = mapper.writeValueAsString(product);
            //Se desactiva transaction porque no se utiliza en la peticion
            responseJson = responseJson.replace("Transaction","TransactionDisabled");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Product resp=(Product) HttpRequestPdv.get(urlApi + product.getId(),responseJson,headers);

        return resp;

    }

    public Product dispatchPts(Product product){
        HashMap<String,String> headers=new HashMap<String,String>();
        headers.put("Content-Type","application/json; charset=UTF-8");
        headers.put("Authorization","token");

        ObjectMapper mapper = new ObjectMapper();
        String responseJson = null;
        try {

            responseJson = mapper.writeValueAsString(product);
            //Se desactiva transaction y noozle last y up, no se utiliza en la peticion
            responseJson = responseJson.replace("Transaction","TransactionDisabled");
            responseJson = responseJson.replace("NozzleUp","NozzleUpDisabled");
            responseJson = responseJson.replace("LastNozzle","LastNozzleDisabled");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Product resp=(Product) HttpRequestPdv.post(urlApi+"sale",responseJson,headers);

        return resp;
    }
    public Product callPts(Product product){
        System.out.println("callPts");
        HashMap<String,String> headers=new HashMap<String,String>();
        headers.put("Content-Type","application/json; charset=UTF-8");
        headers.put("Authorization","token");

        ObjectMapper mapper = new ObjectMapper();
        String responseJson = null;
        try {
            responseJson = mapper.writeValueAsString(product);
            //Se desactiva transaction porque no se utiliza en la peticion
            responseJson = responseJson.replace("Transaction","TransactionDisabled");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Product resp=(Product) HttpRequestPdv.post(urlApi+"status/pumps",responseJson,headers);

        return resp;
    }



}


