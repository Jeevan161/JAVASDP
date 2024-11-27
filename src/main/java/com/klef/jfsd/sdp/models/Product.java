package com.klef.jfsd.sdp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_table")
public class Product 
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "sub_category_id")
  private SubCategory subCategory;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private Member member;
  @Column(name = "product_name",nullable=false,length=50)
  private String name;
  @Column(name = "product_cost",nullable=false)
  private int cost;
  @Column(name = "product_type",nullable=false,length=50)
  private String type;
  @Column(name = "product_rating",nullable=true)
  private int rating;
  @Column(name = "product_unit",nullable=true)
  private String unit;
  @Column(name = "product_description",nullable=false,length=50)
  private String description;
  @Column(name = "product_quantity",nullable=false)
  private int quantity;
  @Column(name = "product_discount",nullable=false)
  private int discount;
  @Column(name = "product_area",nullable=true)
  private String area;
  @Column(name = "product_img_url",nullable=false,length=500)
  private String img_url;
  
  
  
  
  
  
  
  
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public int getRating() {
    return rating;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  public int getCost() {
    return cost;
  }
  public void setCost(int cost) {
    this.cost = cost;
  }
  public String getType() {
    return type;
  }
  public SubCategory getSubcategory() {
	    return subCategory;
	}

  public void setType(String type) {
    this.type = type;
  }
  public void setRating(int rating) {
    this.rating = rating;
  }
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}

public String getImg_url() {
	return img_url;
}
public void setImg_url(String img_url) {
	this.img_url = img_url;
}

public SubCategory getSubCategory() {
	return subCategory;
}
public void setSubCategory(SubCategory subCategory) {
	this.subCategory = subCategory;
}
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}

 
  
}