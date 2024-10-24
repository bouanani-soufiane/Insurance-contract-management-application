package ma.yc.insurance.domain.valueObject;

import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

public record InsuranceId(@UuidGenerator UUID id) {
}
