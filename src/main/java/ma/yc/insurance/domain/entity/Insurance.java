package ma.yc.insurance.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.yc.contract.domain.entity.Contract;
import ma.yc.insurance.domain.valueObject.InsuranceId;

@Entity
@Table(name = "insurances")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {
    @EmbeddedId
    private InsuranceId id;

    @OneToOne(mappedBy = "insurance")
    private Quote quote;

    @OneToOne(mappedBy = "insurance")
    private Contract contract;

}
