package com.demo.Nimap.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
public class Category {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;

	 private String name;

	 @JsonIgnoreProperties("products")
	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	 private List<Product> products;

	public Category() {
		super();
	}

	public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}

	public Category(int id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	 
	 
}
