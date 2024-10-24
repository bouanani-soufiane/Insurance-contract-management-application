package ma.yc.insurance.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.yc.insurance.domain.enums.CarType;
import ma.yc.insurance.domain.valueObject.DriverHistory;

@Entity
@Table(name = "car_insurances")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
