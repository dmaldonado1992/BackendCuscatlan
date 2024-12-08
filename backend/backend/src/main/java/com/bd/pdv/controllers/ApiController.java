package com.bd.pdv.controllers;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.dto.Product;
import com.bd.pdv.models.entity.Order;
import com.bd.pdv.services.IApiService;
import com.bd.pdv.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private IApiService ptsService;

    @Autowired
    private IOrderService ordenService;

    @GetMapping("/products")
    public ResponseEntity<CustomResponse<List<Product>>> products(){

        List<Product> resp = ptsService.getProducts(null);
        CustomResponse<List<Product>> response = new CustomResponse<>();
        response.setOk(true);
        response.setData(resp);

        if (resp == null) {
            response.setOk(false);
            response.setMessage("No se encontraron registros");
            response.setData(null);  // No hay datos ya que no se encontró el producto
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);  // 404 - Not Found
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<CustomResponse<List<Product>>> getById(@PathVariable("id") int id){
        Product product = new Product();
        product.setId(String.valueOf(id));
        Product resp = ptsService.getProductsById(product);

        CustomResponse<Product> response = new CustomResponse<>();
        response.setOk(true);
        response.setData(resp);

        if (resp == null) {
            response.setOk(false);
            response.setMessage("No se encontraron registros");
            response.setData(null);  // No hay datos ya que no se encontró el producto
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);  // 404 - Not Found
        }

        return new ResponseEntity(response, HttpStatus.OK);  // 404 - Not Found
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public ResponseEntity<CustomResponse<List<Order>>> getByID(@PathVariable("id") long id){
        return new ResponseEntity(ordenService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> resp = ordenService.findAll();
        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<CustomResponse<com.bd.pdv.models.entity.Order>> post(@Valid @RequestBody com.bd.pdv.models.entity.Order order) {
        CustomResponse<com.bd.pdv.models.entity.Order> resp = ordenService.save(order);
        return new ResponseEntity(resp, HttpStatus.OK);
    }


    @PostMapping("/callPts")
    public Product callPts(@Valid @RequestBody Product req){
        return ptsService.callPts(req);
    }


    @PostMapping("/setPrices")
    public Product setPrices(@Valid @RequestBody Product req){
        return ptsService.callPts(req);
    }

    @PostMapping("/setPumpNozzlesConfiguration")
    public Product setPumpNozzlesConfiguration(@Valid @RequestBody Product req){
        return ptsService.callPts(req);
    }

}
