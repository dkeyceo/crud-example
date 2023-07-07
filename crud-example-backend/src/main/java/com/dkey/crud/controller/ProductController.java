package com.dkey.crud.controller;

import com.dkey.crud.dto.Message;
import com.dkey.crud.entity.Product;
import com.dkey.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list(){
        List<Product> list = productService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id){
        if (!productService.existsById(id)) {
            return new ResponseEntity(new Message("No exists"), HttpStatus.NOT_FOUND);
        }

        Product product = productService.getOne(id).get();
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}
