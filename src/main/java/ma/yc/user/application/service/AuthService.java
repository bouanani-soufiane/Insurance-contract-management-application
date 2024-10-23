package ma.yc.user.application.service;

import lombok.RequiredArgsConstructor;
import ma.yc.common.application.service.PasswordEncoder;
import ma.yc.common.domain.exception.UserAlreadyExistsException;
import ma.yc.user.application.dto.request.UserLoginDto;
import ma.yc.user.application.dto.request.UserRequestDto;
import ma.yc.user.application.dto.response.UserResponseDto;
import ma.yc.user.domain.entity.User;
import ma.yc.user.domain.repository.UserRepository;
import ma.yc.user.infrastructure.mapping.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto signup ( UserRequestDto dto ) {

        if (repository.existsByEmail(dto.email())) {
            throw new UserAlreadyExistsException("Email already registered");
        }
        User user = mapper.toEntity(dto);
        String hashedPassword = passwordEncoder.encode(dto.password());
        user.setPassword(hashedPassword);
        User saveduser = repository.save(user);
        return mapper.toDto(saveduser);
    }

    public UserResponseDto login ( UserLoginDto dto ) {
        return repository.findByEmail(dto.email())
                .filter(user -> passwordEncoder.matches(dto.password(), user.getPassword()))
                .map(mapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    }

}
