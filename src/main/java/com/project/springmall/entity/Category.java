package com.project.springmall.entity;

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

import com.project.springmall.dto.CategoryDTO.CategoryDTOBuilder;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Category {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  //부모정의
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name ="category_id")
  private Category parent;

  //자식정의
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
  private List<Category> children;
  
  @Column(name ="category_name")
  private String name;
  
  @Column(name ="category_depth")
  private int depth;

  public static CategoryDTOBuilder builder() {
    return null;
  }
}
