package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "workflow", name = "driver")
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId;

    @Generated(value = GenerationTime.INSERT)
    private UUID driverUuid;

    private String driverName;

    private String driverStatus;

}
