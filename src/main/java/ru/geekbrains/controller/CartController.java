package ru.geekbrains.controller;

import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductDTO;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public List<ProductDTO> getAllContextCart() {
        return cartService.getAll();
    }

    public void add(ProductDTO productDTO) {
        cartService.add(productDTO);
    }

    public void delete(ProductDTO productDTO) {
        cartService.delete(productDTO);
    }
}
