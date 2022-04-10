package com.project.springmall.item.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.project.springmall.category.domain.Category;

import lombok.Getter;

@Entity
@Getter
public class Item {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name ="title")
  private String title;
  
  @Column(name ="price")
  private int price;
  
  @Column(name ="description")
  private String description;

  @OneToOne //하나의 ITEM이 하나의 CATEGORY에 해당
  @JoinColumn(name = "category_id")
  private Category caetgory;
  //private String thumbnailUrl;

  
}
