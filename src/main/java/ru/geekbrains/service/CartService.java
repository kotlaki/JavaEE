package ru.geekbrains.service;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartService implements Serializable {
    private List<ProductDTO> cart = new ArrayList<>();

    public List<ProductDTO> getAll() {
        return cart;
    }

    public void add(ProductDTO productDTO) {
        cart.add(productDTO);
    }

    public void delete(ProductDTO productDTO) {
        cart.remove(productDTO);
    }

}
