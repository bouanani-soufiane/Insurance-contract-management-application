package ma.yc.user.application.service;

import lombok.RequiredArgsConstructor;
import ma.yc.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

  
}
