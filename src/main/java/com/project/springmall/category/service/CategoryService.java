package com.project.springmall.category.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.project.springmall.category.domain.Category;
import com.project.springmall.category.domain.CategoryDTO;
import com.project.springmall.category.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {
  
  @Autowired
  private CategoryRepository cr;

  public Long saveCategory (CategoryDTO categoryDTO){    
    Category category = categoryDTO.toEntity();
    
    //대분류 등록
    if(categoryDTO.getCategory_id() == null){
      //JPA 사용하여 DB에서 name의 중복값을 검사. (대분류에서만 가능)
      System.out.println(categoryDTO.getName());
      if (cr.existsByName(categoryDTO.getName())){
        throw new RuntimeException("이미 존재하는 main 카테고리입니다.");
      }else{
        cr.save(category);
      }

    }else{ //서브 카테고리 등록
      Long mainCategoryId = categoryDTO.getCategory_id();
      Category mainCategory = cr.findById(mainCategoryId)
      .orElseThrow(() -> new IllegalArgumentException("부모 카테고리 없음"));
      cr.save(category);
    }
    return cr.save(category).getId();

  }

   //전체 카테고리 조회
   public List<Category> findAll(){
    List<Category> cates = new ArrayList<>();
    cr.findAll().forEach(
      e -> cates.add(e)
    );
    return cates;    
    }


    //삭제
    public void deleteCategory(Long id) {
      cr.deleteById(id);
    }

    //수정
    public Long updateCategory(Long id, CategoryDTO categoryDTO) {
      Optional<Category> optionalCate = cr.findById(id);
      if (!optionalCate.isPresent()) {
        throw new EntityNotFoundException(
                    "해당 카테고리가 존재하지 않습니다.");
      }
      cr.save(categoryDTO.toEntity());

      return null;
    }





}
