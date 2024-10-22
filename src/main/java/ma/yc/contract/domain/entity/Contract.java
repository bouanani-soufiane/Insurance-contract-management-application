package ma.yc.contract.domain.entity;

import jakarta.persistence.*;
import ma.yc.user.domain.entity.User;

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private long ID;

    @ManyToOne
    private User user ;
}
