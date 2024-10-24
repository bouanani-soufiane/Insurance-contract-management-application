package ma.yc.contract.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import ma.yc.contract.domain.valueObject.ContractId;
import ma.yc.insurance.domain.entity.Insurance;
import ma.yc.user.domain.entity.User;

@Entity
public class Contract {

    @EmbeddedId
    private ContractId ID;

    @ManyToOne
    private User user;

    @OneToOne
    private Insurance insurance;
}
