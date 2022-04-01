package com.project.springmall.dto;

import com.project.springmall.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@ToString
@Builder
public class CategoryDTO {
  private Long id;
  private String category_name;
  private int depth;

  


  
}
