package ma.yc.user.domain.valueObject;

import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.util.UUID;

public record UserId(@UuidGenerator UUID id) implements Serializable {
}