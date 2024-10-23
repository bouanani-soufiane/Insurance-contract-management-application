package ma.yc.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(@NotBlank String username, @NotBlank String email, @NotBlank String password,
                             @NotBlank String phone, @NotBlank String address) {
}