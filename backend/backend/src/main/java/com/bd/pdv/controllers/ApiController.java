package com.bd.pdv.controllers;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.dto.Product;
import com.bd.pdv.services.IApiService;
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

    @GetMapping("/products")
    public List<Product> products(){
        return ptsService.getProducts(null);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<CustomResponse<List<Product>>> getById(@PathVariable("id") int id){
        Product product = new Product();
        product.setId(String.valueOf(id));
        Optional<Product> resp = Optional.ofNullable(ptsService.getProductsById(product));
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
