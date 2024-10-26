package ma.yc.insurance.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ma.yc.insurance.domain.enums.CoverageType;

public record HealthInsuranceRequestDto(@Positive int age, Boolean hasChronicConditions,
                                        @NotNull CoverageType coverageType) {
}
