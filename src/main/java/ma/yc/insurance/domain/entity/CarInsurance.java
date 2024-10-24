package ma.yc.insurance.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import ma.yc.insurance.domain.enums.CarType;
import ma.yc.insurance.domain.valueObject.DriverHistory;

@Entity
public class CarInsurance extends Insurance {
    @Positive
    private int driverAge;
    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    @Embedded
    private DriverHistory driverHistory;

}
