package ma.yc.insurance.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.insurance.application.dto.request.CarInsuranceRequestDto;
import ma.yc.insurance.domain.entity.CarInsurance;
import ma.yc.insurance.domain.repository.InsuranceRepository;
import ma.yc.insurance.infrastructure.mapping.CarInsuranceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InsuranceService {
    private final CarInsuranceMapper mapper;
    private final InsuranceRepository repository;

    public CarInsurance save(CarInsuranceRequestDto dto) {
        log.info("Saving car insurance request: {}", dto);

        CarInsurance entity = mapper.toEntity(dto);
        log.debug("Mapped to entity: {}", entity);

        CarInsurance savedEntity = repository.save(entity);
        log.info("Successfully saved car insurance with ID: {}", savedEntity.getId());

        return savedEntity;
    }
}