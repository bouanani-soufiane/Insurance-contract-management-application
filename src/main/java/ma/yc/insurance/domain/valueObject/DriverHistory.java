package ma.yc.insurance.domain.valueObject;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record DriverHistory(@NotNull @PositiveOrZero int accidentCount,

                            @NotNull @PositiveOrZero int infractionCount,

                            @NotNull @PositiveOrZero int yearsAccidentFree) {
    public double calculateHistoryImpact () {
        if (yearsAccidentFree >= 3) {
            return -0.20;
        } else {
            return 0.10;
        }
    }
}
