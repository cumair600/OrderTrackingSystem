package org.example.controller;

import org.example.dto.OrderListDto;
import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/get-all")
    public List<OrderListDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
