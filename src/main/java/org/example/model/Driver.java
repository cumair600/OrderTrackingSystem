package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(schema = "workflow", name = "driver")
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue
    private Integer driverId;

    private UUID driverUuid;

    private String driverName;

    private String driverStatus;
}
