package org.example.service;


import org.example.model.Order;

import java.util.List;

public interface OrderService {
    public Order saveOrder(Order order);

    public List<Order> getAllOrders();
}
