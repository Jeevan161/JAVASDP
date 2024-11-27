package com.klef.jfsd.sdp.services;

import com.klef.jfsd.sdp.models.Cart;
import com.klef.jfsd.sdp.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {

    private CartRepository cartRepository;

    @Autowired
    public void CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getCartItemsByCustomerEmail(String email) {
        return cartRepository.findCartItemsByCustomerEmail(email);
    }
}
