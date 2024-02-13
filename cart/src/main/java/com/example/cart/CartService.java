package com.example.cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart createCart(Cart cart);
    void deleteCart(Long id);

}
