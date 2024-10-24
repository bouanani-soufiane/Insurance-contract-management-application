package ma.yc.insurance.domain.entity;

import jakarta.persistence.*;

@Entity
public class Quote {
    @Id
    private Long id;
    private double total;

    @OneToOne
    private Insurance insurance;
}
