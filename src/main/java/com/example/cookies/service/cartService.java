package com.example.cookies.service;

import com.example.cookies.dao.cartDao;
import com.example.cookies.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartService {
    @Autowired
    private cartDao dao;

    public Cart addCart(Cart cart) {
        return dao.addCart(cart);
    }

    //    public Cart getCart(int id)
//    {
//        return cartDao.getCart(id);
//    }
    public List<Cart> getCarts() {
        return this.dao.getCarts();
    }

    public void updateCart(Cart cart) {
        dao.updateCart(cart);
    }

    public void deleteCart(Cart cart) {
        dao.deleteCart(cart);
    }

//    pubiic List<Cart> getCartByUserId(int customer_id){
//        return cartDao.getCartsByCustomerID(customer_id);
//    }


}