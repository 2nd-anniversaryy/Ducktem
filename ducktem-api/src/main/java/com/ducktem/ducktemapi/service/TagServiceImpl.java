package com.ducktem.ducktemapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.Tag;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.repository.TagRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService{

  private final TagRepository tagRepository;
  private final ProductRepository productRepository;

  @Override
  public void add(String name, Long productId, byte ban) {

      Tag tag = new Tag();
      Product product = null;
      Optional<Product> opt = productRepository.findById(productId);
      if(opt.isPresent())
        product = opt.get();  
			tag.setName(name);
			tag.setProduct(product);
			tag.setBan(ban);
      tagRepository.save(tag);
  }
  
}
