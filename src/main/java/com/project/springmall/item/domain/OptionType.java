package com.project.springmall.item.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Entity
@Getter
public class OptionType {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne //여러 optionType이 하나의 Item에 해당
  @JoinColumn(name = "item_id", nullable = false)
  private Item item;

  @Column(name = "option_type_name", nullable = false)
  private String name;


}
