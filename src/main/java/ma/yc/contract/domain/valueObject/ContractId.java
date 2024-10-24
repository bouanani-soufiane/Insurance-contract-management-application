package ma.yc.contract.domain.valueObject;

import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

public record ContractId(@UuidGenerator UUID id) {
}
