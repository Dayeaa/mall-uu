package com.project.springmall.category.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor 
@Getter
@Setter
public class CategoryDTO {
  private Long id;
  private String name;
  private Long category_id;//부모카테고리면 null, 자식이면 부모의 id
  private int depth;
  


  public CategoryDTO(Category entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.depth = entity.getDepth();
    if(entity.getMainCategory() == null){
      this.category_id = null;
    }else{
      this.category_id = entity.getMainCategory().getId();
    }
  }

  
  public Category toEntity(){
    return Category.builder()
    .name(name)
    .depth(depth)
    .build();    
  }
  


  
}
