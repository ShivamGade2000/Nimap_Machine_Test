package com.demo.Nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.Nimap.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
