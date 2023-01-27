package com.ducktem.ducktemapi.service;

import jakarta.servlet.http.HttpServletRequest;

public interface TagService {

  void add(String name,Long productId, byte ban);
  
}
