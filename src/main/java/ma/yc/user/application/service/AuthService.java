package ma.yc.user.application.service;

import ma.yc.common.application.service.PasswordEncoder;
import ma.yc.user.application.dto.request.UserRequestDto;
import ma.yc.user.application.dto.response.UserResponseDto;
import ma.yc.user.domain.entity.User;
import ma.yc.user.domain.repository.UserRepository;
import ma.yc.user.infrastructure.mapping.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService {


    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public AuthService ( UserRepository userRepository, UserMapper mapper, PasswordEncoder passwordEncoder ) {
        this.repository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDto signup ( UserRequestDto dto ) {
        User user = mapper.toEntity(dto);
        String hashedPassword = passwordEncoder.encode(dto.password());
        user.setPassword(hashedPassword);
        User saveduser = repository.save(user);
        return mapper.toDto(saveduser);
    }

    @Transactional
    public UserResponseDto login ( UserRequestDto dto ) {

        Optional<User> userOptional = repository.findByEmail(dto.email());

        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return mapper.toDto(user);
    }

}
