package com.dkey.crud.service;

import com.dkey.crud.entity.Product;
import com.dkey.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }

    public Optional<Product> getOne(Long id){
        return productRepository.findById(id);
    }

    public Optional<Product> getByName(String name){
        return productRepository.findByName(name);
    }

    public void save (Product product){
        productRepository.save(product);
    }
    public void delete (Long id){
        productRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return productRepository.existsById(id);
    }
    public boolean existsByName(String name){
        return productRepository.existsByName(name);
    }

}
