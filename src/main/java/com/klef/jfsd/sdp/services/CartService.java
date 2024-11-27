package com.klef.jfsd.sdp.services;

import com.klef.jfsd.sdp.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartItemsByCustomerEmail(String email);
}
