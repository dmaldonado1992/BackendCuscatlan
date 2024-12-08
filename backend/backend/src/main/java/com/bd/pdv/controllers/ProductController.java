package com.bd.pdv.controllers;

import com.bd.pdv.dto.CustomResponse;
import com.bd.pdv.models.entity.Product;
import com.bd.pdv.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api2")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/product")
    public ResponseEntity<CustomResponse<List<Product>>> getAll(){
        CustomResponse<List<Product>> resp = service.findAll();
        return new ResponseEntity(resp, HttpStatus.OK);
    }


    @PostMapping("/product")
    public ResponseEntity<CustomResponse<Product>> post(@Valid @RequestBody Product product) {
        CustomResponse<Product> resp = service.save(product);
        return new ResponseEntity(resp, HttpStatus.OK);
    }
}
