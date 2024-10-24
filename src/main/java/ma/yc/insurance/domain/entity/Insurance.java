package ma.yc.insurance.domain.entity;

import jakarta.persistence.*;
import ma.yc.contract.domain.entity.Contract;
import ma.yc.insurance.domain.valueObject.InsuranceId;

import java.util.List;

@Entity
@Table(name = "insurances")
@Inheritance(strategy = InheritanceType.JOINED)
public class Insurance {
    @EmbeddedId
    private InsuranceId id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insurance")
    private List<Quote> quotes;

    @OneToOne(mappedBy = "insurance")
    private Contract contract;

}
