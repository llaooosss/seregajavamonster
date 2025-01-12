package com.example.cookies.service;

import com.example.cookies.dao.productDao;
import com.example.cookies.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    private productDao dao;

    public List<Product> getProducts(){
        return this.dao.getProducts();
    }

    public Product addProduct(Product product) {
        return this.dao.addProduct(product);
    }

    public Product getProduct(int id) {
        return this.dao.getProduct(id);
    }

    public Product updateProduct(int id,Product product){
        product.setId(id);
        return this.dao.updateProduct(product);
    }
    public boolean deleteProduct(int id) {
        return this.dao.deletProduct(id);
    }


}