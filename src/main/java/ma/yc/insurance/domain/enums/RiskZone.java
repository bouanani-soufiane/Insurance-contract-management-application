package ma.yc.insurance.domain.enums;

public enum RiskZone {
    LOW_RISK("Low Risk", 0.0),
    MEDIUM_RISK("Medium Risk", 0.05),
    HIGH_RISK("High Risk", 0.10);

    private final String label;
    private final double riskPremiumPercentage;

    RiskZone ( String label, double riskPremiumPercentage ) {
        this.label = label;
        this.riskPremiumPercentage = riskPremiumPercentage;
    }

    public double getRiskPremiumPercentage () {
        return riskPremiumPercentage;
    }
}