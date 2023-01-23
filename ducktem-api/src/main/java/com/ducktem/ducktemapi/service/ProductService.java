package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {

  List<Product> getList(int page, int size);
  Product get(Long id);
  
}
