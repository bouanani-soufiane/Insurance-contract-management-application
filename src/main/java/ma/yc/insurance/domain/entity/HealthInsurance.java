package ma.yc.insurance.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.yc.insurance.domain.enums.CoverageType;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "health_insurances")

public class HealthInsurance extends Insurance {

    @Positive
    private int age;

    private Boolean hasChronicConditions;

    @Enumerated(EnumType.STRING)
    private CoverageType coverageType;
}
