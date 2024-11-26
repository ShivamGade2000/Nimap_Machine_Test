package com.demo.Nimap.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Nimap.entity.Category;
import com.demo.Nimap.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository crepo;
	
	public Category updateCategoryById(int id, String name) {
		Category c=crepo.findById(id).get();
		c.setName(name);
		return crepo.save(c);
	}
	
	public String deleteById(int id) {
		Category c=null;
		try {
			c=crepo.findById(id).get();
			crepo.delete(c);
			return "deleted Succesfully";
		}catch(Exception e){
			return "Category Not Found";
		}
	}
}
