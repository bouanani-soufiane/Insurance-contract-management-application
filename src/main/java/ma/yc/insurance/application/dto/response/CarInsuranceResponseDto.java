package ma.yc.insurance.application.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ma.yc.insurance.domain.enums.CarType;
import ma.yc.insurance.domain.valueObject.DriverHistory;
import ma.yc.insurance.domain.valueObject.InsuranceId;

public record CarInsuranceResponseDto(@NotNull InsuranceId id, @Positive int driverAge, @NotBlank String model,
                                      @NotBlank String brand, @NotBlank CarType carType,
                                      @NotBlank DriverHistory driverHistory) {
}
