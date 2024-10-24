package ma.yc.user.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(@NotBlank String email, @NotBlank String password) {
}
