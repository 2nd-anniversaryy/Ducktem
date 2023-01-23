package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductRepository repository; 

  @Override
  public List<Product> getList(int page, int size) {

    List<Product> list = repository.findAll();

    return list;
  }

  @Override
  public Product get(Long id) {

    Product product = null; 

    Optional<Product> opt = repository.findById(id);
    if(opt.isPresent())
      product = opt.get();
    
    return product;
  }
  
}
