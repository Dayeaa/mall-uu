package com.project.springmall.entity;

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
public class OptionDetail {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne //여러 optiondetail이 하나의 optiontype에 해당
  @JoinColumn(name = "option_type_id", nullable = false)
  private OptionType optiontype;

  @Column(name = "option_detail_name", nullable = false)
  private String name;

  @Column(name = "option_detail_price", nullable = false)
  private int price;
}
