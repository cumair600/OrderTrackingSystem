package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.*;
import java.util.UUID;

@Entity
@Table(schema = "workflow", name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private Integer customerId;

    private UUID customerUuid;

    private String customerName;

    private String customerLocation; // Point with (x,y) coordinates
}
