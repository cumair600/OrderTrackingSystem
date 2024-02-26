package org.example.repository;

import org.example.dto.OrderListDto;
import org.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select new org.example.dto.OrderListDto(o.orderId, o.orderType, o.orderContent, c.customerName, " +
            "d.driverName, o.orderStatus, o.orderProgress) from Order o " +
            "join Customer c on c.customerId = o.fkCustomerId left join Driver d " +
            "on d.driverId = o.fkDriverId")
    List<OrderListDto> findAllOrders();

    List<Order> findAllByOrderStatusIn(List<String> statuses);
}
