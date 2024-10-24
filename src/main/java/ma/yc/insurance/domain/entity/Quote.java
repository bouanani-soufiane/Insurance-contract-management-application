package ma.yc.insurance.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Quote {
    @Id
    private Long id;
}
