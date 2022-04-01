package com.project.springmall.repository;

import com.project.springmall.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
  
}
