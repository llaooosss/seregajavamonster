package com.example.cookies.service;

import com.example.cookies.dao.categoryDao;
import com.example.cookies.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {
    @Autowired
    private categoryDao dao;

    public Category addCategory(String name) {
        return this.dao.addCategory(name);
    }

    public List<Category> getCategories(){
        return this.dao.getCategories();
    }

    public Boolean deleteCategory(int id) {
        return this.dao.deletCategory(id);
    }

    public Category updateCategory(int id,String name) {
        return this.dao.updateCategory(id, name);
    }

    public Category getCategory(int id) {
        return this.dao.getCategory(id);
    }
}