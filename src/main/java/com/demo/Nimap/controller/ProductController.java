package com.demo.Nimap.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Nimap.entity.Category;
import com.demo.Nimap.entity.Product;
import com.demo.Nimap.entity.ProductDTO;
import com.demo.Nimap.repository.CategoryRepository;
import com.demo.Nimap.repository.ProductRepository;
import com.demo.Nimap.service.CategoryService;
import com.demo.Nimap.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository preo;
	
	@Autowired
	private ProductService pserv;
	
	@Autowired
	private CategoryRepository crepo;
	
	@GetMapping("/getpro")
	public List<Product> getallProduct(){
		return preo.findAll();
	}
	
	@PostMapping("/createProduct")
	public Product addProduct(@RequestBody ProductDTO p) {
		System.out.print(p);
		Product pro=new Product();
		Category c = crepo.findById(p.getCat()).get();
		pro.setCategory(c);
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		return preo.save(pro);
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getProdcutById(@PathVariable int id) {
		return preo.findById(id).get();
	}
	
	@PutMapping("/updateproduct/{id}")
	public Product updateProductById(@PathVariable int id, @RequestBody ProductDTO p) {
		return pserv.updateProduct(id, p);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String delteProdcutById(@PathVariable int id) {
		return pserv.deleteProductById(id);
	}
}
