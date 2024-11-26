package com.demo.Nimap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Nimap.entity.Category;
import com.demo.Nimap.repository.CategoryRepository;
import com.demo.Nimap.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository crepo;
	
	@Autowired
	private CategoryService cserv;
	
	@GetMapping("/getcato")
	public List<Category> getAllCategory(){
		return crepo.findAll();
	}
	
	@PostMapping("/addcate")
	public Category addCategory(@RequestBody Category cate) {
		return crepo.save(cate);
	}
	
	@GetMapping("/getcategory/{id}")
	public Category getCategoryByID(@PathVariable int id) {
		return crepo.findById(id).get();
	}
	
	@PutMapping("/updatecategory/{id}")
	public Category updateById(@PathVariable int id,@RequestParam String name) {
		return cserv.updateCategoryById(id, name);
	}
	
	@DeleteMapping("/deletecate/{id}")
	public String deleteById(@PathVariable int id) {
		return cserv.deleteById(id);
	}
}
