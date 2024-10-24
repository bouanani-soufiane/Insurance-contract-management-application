package ma.yc.insurance.domain.valueObject;

public record SecuritySystem(boolean hasAlarm, boolean hasCameras) {

    public boolean isValid () {
        return hasAlarm || hasCameras;
    }

    public double getSecurityDiscount () {
        return isValid() ? -0.15 : 0.15;
    }
}