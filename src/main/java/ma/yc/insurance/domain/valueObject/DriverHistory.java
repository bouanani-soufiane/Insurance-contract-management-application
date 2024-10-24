package ma.yc.insurance.domain.valueObject;

public record DriverHistory(int accidentCount, int infractionCount, int yearsAccidentFree) {
    public double calculateHistoryImpact () {
        if (yearsAccidentFree >= 3) {
            return -0.20;
        } else {
            return 0.10;
        }
    }
}
