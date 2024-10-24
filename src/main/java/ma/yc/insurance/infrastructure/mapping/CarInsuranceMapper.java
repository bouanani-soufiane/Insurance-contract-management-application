package ma.yc.insurance.infrastructure.mapping;

import ma.yc.insurance.application.dto.request.CarInsuranceRequestDto;
import ma.yc.insurance.domain.entity.CarInsurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarInsuranceMapper {
    CarInsurance toEntity ( CarInsuranceRequestDto dto );
}