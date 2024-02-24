package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "workflow", name = "order")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Integer orderId;

    private UUID orderUuid;

    @ManyToOne
    @JoinColumn(name = "fk_customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "fk_driver_id", referencedColumnName = "driverId")
    private Driver driver;

    private String orderType;

    private String orderContent;

    private String orderStatus;

    private Integer orderProgress;
}
