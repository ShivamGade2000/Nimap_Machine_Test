package com.demo.Nimap.entity;

public class ProductDTO {
	
	public String name;
	public double price;
	public int cat;
	
	public ProductDTO(String name, double price, int cat) {
		super();
		this.name = name;
		this.price = price;
		this.cat = cat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	

}
