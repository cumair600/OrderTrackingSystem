package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.awt.*;
import java.util.UUID;

@Entity
@Table(schema = "workflow", name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Generated(value = GenerationTime.INSERT)
    private UUID customerUuid;

    private String customerName;

    private String customerLocation; // Point with (x,y) coordinates
}
