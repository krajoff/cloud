package com.example.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartRepository cartrepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartrepository.findAll();
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartrepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartrepository.deleteById(id);
    }
}
