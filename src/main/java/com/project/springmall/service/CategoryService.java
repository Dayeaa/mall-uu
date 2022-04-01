package com.project.springmall.service;

import com.project.springmall.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  
  @Autowired
  private CategoryRepository cr;

  public Object findAll() {
    return null;
  }




}
