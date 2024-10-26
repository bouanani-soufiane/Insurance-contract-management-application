package ma.yc.insurance.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.insurance.application.dto.request.CarInsuranceRequestDto;
import ma.yc.insurance.application.dto.request.HealthInsuranceRequestDto;
import ma.yc.insurance.application.dto.request.HomeInsuranceRequestDto;
import ma.yc.insurance.domain.entity.CarInsurance;
import ma.yc.insurance.domain.entity.HealthInsurance;
import ma.yc.insurance.domain.entity.HomeInsurance;
import ma.yc.insurance.domain.entity.Insurance;
import ma.yc.insurance.domain.repository.InsuranceRepository;
import ma.yc.insurance.infrastructure.mapping.CarInsuranceMapper;
import ma.yc.insurance.infrastructure.mapping.HealthInsuranceMapper;
import ma.yc.insurance.infrastructure.mapping.HomeInsuranceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InsuranceService {

    private final CarInsuranceMapper carInsuranceMapper;
    private final HealthInsuranceMapper healthInsuranceMapper;
    private final HomeInsuranceMapper homeInsuranceMapper;
    private final InsuranceRepository repository;

    public CarInsurance save ( CarInsuranceRequestDto dto ) {
        return saveInsurance(carInsuranceMapper.toEntity(dto));
    }

    public HealthInsurance save ( HealthInsuranceRequestDto dto ) {
        return saveInsurance(healthInsuranceMapper.toEntity(dto));
    }

    public HomeInsurance save ( HomeInsuranceRequestDto dto ) {
        return saveInsurance(homeInsuranceMapper.toEntity(dto));
    }

    private <Entity extends Insurance> Entity saveInsurance ( Entity entity ) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            log.error("Failed to save insurance", e);
            throw new RuntimeException("Failed to save insurance: " + e.getMessage(), e);
        }
    }
}
