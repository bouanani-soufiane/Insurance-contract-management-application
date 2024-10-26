package ma.yc.insurance.infrastructure.mapping;

import ma.yc.insurance.application.dto.request.HealthInsuranceRequestDto;
import ma.yc.insurance.domain.entity.HealthInsurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HealthInsuranceMapper {
    HealthInsurance toEntity ( HealthInsuranceRequestDto dto );
}
