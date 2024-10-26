package ma.yc.insurance.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.yc.insurance.domain.enums.PropertyType;
import ma.yc.insurance.domain.valueObject.Address;
import ma.yc.insurance.domain.valueObject.SecuritySystem;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "home_insurances")
public class HomeInsurance extends Insurance {

    @Positive
    private double propertyValue;

    @Enumerated
    private PropertyType propertyType;

    @Embedded
    private Address address;

    @Embedded
    private SecuritySystem securitySystem;

}
