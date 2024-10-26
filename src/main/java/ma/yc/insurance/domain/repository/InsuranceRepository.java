package ma.yc.insurance.domain.repository;

import ma.yc.insurance.domain.entity.Insurance;
import ma.yc.insurance.domain.valueObject.InsuranceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, InsuranceId> {
}
