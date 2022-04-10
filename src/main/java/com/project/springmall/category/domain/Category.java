package com.project.springmall.category.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  //부모정의
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name ="category_id")
  private Category mainCategory;

  //자식정의
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainCategory")
  private List<Category> subCategory;
  
  @Column(name ="category_name")
  private String name;

  @Column(name ="depth")
  private int depth;

  

  @Builder
  public Category(Long id, Category mainCategory, String name, int depth) {
    this.id = id;
    this.mainCategory = mainCategory;
    this.name = name;
    this.depth = depth;
  }

  

}
