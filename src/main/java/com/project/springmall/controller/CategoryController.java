package com.project.springmall.controller;

import com.project.springmall.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
  
  private CategoryService cs;
  
  @Autowired
  public CategoryController(CategoryService cs){
    this.cs = cs;
  }

}
