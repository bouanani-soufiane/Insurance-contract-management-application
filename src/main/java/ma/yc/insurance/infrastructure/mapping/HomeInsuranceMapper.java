package ma.yc.insurance.infrastructure.mapping;

import ma.yc.insurance.application.dto.request.HomeInsuranceRequestDto;
import ma.yc.insurance.domain.entity.HomeInsurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HomeInsuranceMapper {
    HomeInsurance toEntity ( HomeInsuranceRequestDto dto );
}
