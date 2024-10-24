package ma.yc.insurance.domain.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import ma.yc.insurance.domain.enums.CoverageType;
import ma.yc.insurance.domain.valueObject.MedicalHistory;

@Entity
public class HealthInsurance extends Insurance {

    private int age;
    @Embedded
    private MedicalHistory medicalHistory;
    @Enumerated
    private CoverageType coverageType;
}
