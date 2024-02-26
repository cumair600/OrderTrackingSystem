package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderListDto {
    private Integer orderId;
    private String orderType;
    private String orderContent;
    private String customerName;
    private String driverName;
    private String orderStatus;
    private Integer orderProgress;

    public OrderListDto(Integer orderId, String orderType, String orderContent, String customerName, String driverName, String orderStatus, Integer orderProgress) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.orderContent = orderContent;
        this.customerName = customerName;
        this.driverName = driverName;
        this.orderStatus = orderStatus;
        this.orderProgress = orderProgress;
    }
}
