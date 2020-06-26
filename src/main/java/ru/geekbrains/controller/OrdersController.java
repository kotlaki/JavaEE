package ru.geekbrains.controller;

import ru.geekbrains.persist.OrderRepository;
import ru.geekbrains.persist.Orders;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class OrdersController implements Serializable {
    @EJB
    private OrderRepository orderRepository;

    private Orders orders;

    public String createOrder() {
        this.orders = new Orders();
        return "/order.xhtml?faces-redirect=true";
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public String editOrder(Orders order) {
        this.orders = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public String deleteOrder(Orders order) throws SQLException {
        orderRepository.delete(order.getId());
        return "/index.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        if(orders.getId() == null) {
            orderRepository.insert(orders);
        } else {
            orderRepository.update(orders);
        }
        return "/order.xhtml?faces-redirect=true";
    }

    public Orders getOrders() {
        return orders;
    }
}
