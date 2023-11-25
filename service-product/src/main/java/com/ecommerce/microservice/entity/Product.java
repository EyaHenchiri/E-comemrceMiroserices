package com.ecommerce.microservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "produits")
public class Product implements Serializable {
 

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "product_name")
 
    private String productName;

 

    private float price;

  
    private String description;


  
    private String category;
    
    @Column(name = "image_url")
	private String imageUrl;
  
  
    private int availability;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}
	
	   public Product() {
		super();
	}

	public Product(String productName, float price, String description, String category, int availability,String imageUrl) {
			super();
			this.productName = productName;
			this.price = price;
			this.description = description;
			this.category = category;
			this.availability = availability;
			this.imageUrl=imageUrl;
		}

}
