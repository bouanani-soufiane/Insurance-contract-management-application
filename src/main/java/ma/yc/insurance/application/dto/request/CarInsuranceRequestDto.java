package ma.yc.insurance.application.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ma.yc.insurance.domain.enums.CarType;
import ma.yc.insurance.domain.valueObject.DriverHistory;

public record CarInsuranceRequestDto(@Positive int driverAge, @NotBlank String model, @NotBlank String brand,
                                     @NotNull CarType carType, @NotNull @Valid DriverHistory driverHistory) {
}
