package ma.yc.insurance.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import ma.yc.insurance.domain.enums.PropertyType;
import ma.yc.insurance.domain.valueObject.Address;
import ma.yc.insurance.domain.valueObject.SecuritySystem;

@Entity
public class HomeInsurance extends Insurance {
    private double propertyValue;
    @Enumerated
    private PropertyType propertyType;
    @Embedded
    private Address address;
    @Embedded
    private SecuritySystem securitySystem;

}
