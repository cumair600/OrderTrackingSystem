package org.example.service;

import org.example.constant.Constants;
import org.example.dto.OrderListDto;
import org.example.model.Driver;
import org.example.model.Order;
import org.example.repository.DriverRepository;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrderListDto> getAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public void updateOrderStatusAndProgress() {
        List<Order> activeOrders = orderRepository.findAllByOrderStatusIn(new ArrayList<String>(Arrays.asList(Constants.NEW, Constants.IN_PROGRESS)));
        for (Order order : activeOrders) {
            if (order.getFkDriverId() == null) {
                Driver driver = driverRepository.findTopByDriverStatus(Constants.AVAILABLE).orElse(null);
                if( driver != null) {
                    order.setFkDriverId(driver.getDriverId());
                    order.setOrderStatus(Constants.IN_PROGRESS); // change status from NEW to IN_PROGRESS
                    driver.setDriverStatus(Constants.BUSY);
                    orderRepository.save(order);
                    driverRepository.save(driver);
                }
            } else {
                order.setOrderProgress(order.getOrderProgress() + 20);
                if (order.getOrderProgress() == 100) {
                    order.setOrderStatus(Constants.COMPLETED);
                    Driver driver = driverRepository.findById(order.getFkDriverId()).orElse(null);
                    if(driver != null) {
                        driver.setDriverStatus(Constants.AVAILABLE);
                        driverRepository.save(driver);
                    }
                }
                orderRepository.save(order);
            }
        }
    }


}
