package com.project.springmall.category;

import java.util.List;

import com.project.springmall.category.domain.Category;
import com.project.springmall.category.domain.CategoryDTO;
import com.project.springmall.category.service.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor //@RequiredArgsContstructor를 통해 private final로 선언한 CategoryService 인스턴스를 주입받는다. DI는 생성자주입, setter를 활용한 주입 등이 있는데, 최근에는 이 어노테이션을 통해 의존성 주입을 받는 것이 트렌드다.
public class CategoryController {
  
  private final CategoryService cs;

  //카테고리 생성
  @PostMapping
  @ResponseBody
  public Long saveCategory (CategoryDTO categoryDTO){
    return cs.saveCategory(categoryDTO);
  }

  //카테고리 전체 조회
  @GetMapping
  public ResponseEntity<List<Category>> getAllItems(){
    return ResponseEntity.ok(cs.findAll());
  }

  //카테고리 수정 ~ing
  @PatchMapping ("/{id}")
  @ResponseBody
  public Long updateCategory (@PathVariable Long id,
                              CategoryDTO categoryDTO) {
      return cs.updateCategory(id, categoryDTO);
  }
  
  //카테고리 삭제
  @DeleteMapping ("/{id}")
  @ResponseBody
  public void deleteCategory (@PathVariable Long id) {
      cs.deleteCategory(id);
  }

}
