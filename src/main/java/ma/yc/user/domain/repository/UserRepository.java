package ma.yc.user.domain.repository;

import ma.yc.user.domain.entity.User;
import ma.yc.user.domain.valueObject.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByEmail (String email);
    boolean existsByEmail(String email);
}
