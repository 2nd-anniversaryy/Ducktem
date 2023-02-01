package com.ducktem.ducktemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
  
}
