package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "workflow", name = "order")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Generated(value = GenerationTime.INSERT)
    private UUID orderUuid;

    @Column(name = "fk_customer_id") // Map to the foreign key column
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "fk_driver_id", referencedColumnName = "driverId")
    private Driver driver;

    private String orderType;

    private String orderContent;

    private String orderStatus;

    private Integer orderProgress;
}
