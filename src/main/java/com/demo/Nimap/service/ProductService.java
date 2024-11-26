package com.demo.Nimap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Nimap.entity.Category;
import com.demo.Nimap.entity.Product;
import com.demo.Nimap.entity.ProductDTO;
import com.demo.Nimap.repository.CategoryRepository;
import com.demo.Nimap.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prepo;
	
	@Autowired
	private CategoryRepository crepo;
	
	public Product updateProduct(int id , ProductDTO p) {
		Product pro=prepo.findById(id).get();
		Category c= crepo.findById(p.getCat()).get();
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setCategory(c);
		return prepo.save(pro);
	}

	public String deleteProductById(int id) {
		try {
			Product p=prepo.findById(id).get();
			prepo.delete(p);
			return "Deleted";
		}catch(Exception e) {
			return "Not Found";
		}
	}
}
