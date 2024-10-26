package ma.yc.insurance.application.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ma.yc.insurance.domain.enums.PropertyType;
import ma.yc.insurance.domain.valueObject.Address;
import ma.yc.insurance.domain.valueObject.SecuritySystem;

public record HomeInsuranceRequestDto(@Positive double propertyValue, @NotNull PropertyType propertyType,
                                      @Valid @NotNull Address address, @Valid @NotNull SecuritySystem securitySystem) {
}
