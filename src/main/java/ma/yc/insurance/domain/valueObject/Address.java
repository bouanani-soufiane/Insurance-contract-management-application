package ma.yc.insurance.domain.valueObject;

import ma.yc.insurance.domain.enums.RiskZone;

import java.util.Objects;

public record Address(String street, String city, RiskZone riskZone) {
    public Address {
        Objects.requireNonNull(street, "Street cannot be null");
        Objects.requireNonNull(city, "City cannot be null");
        Objects.requireNonNull(riskZone, "Risk zone cannot be null");
    }

    public boolean isInRiskZone () {
        return !RiskZone.LOW_RISK.equals(riskZone);
    }
}