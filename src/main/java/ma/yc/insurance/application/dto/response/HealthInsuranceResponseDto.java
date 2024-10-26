package ma.yc.insurance.application.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ma.yc.insurance.domain.enums.CoverageType;
import ma.yc.insurance.domain.valueObject.InsuranceId;

public record HealthInsuranceResponseDto(@NotNull InsuranceId id, @Positive int age, Boolean hasChronicConditions,
                                         @NotNull CoverageType coverageType) {
}