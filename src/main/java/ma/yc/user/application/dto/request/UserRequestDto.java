package ma.yc.user.application.dto.request;

import jakarta.validation.constraints.NotNull;

public record UserRequestDto(@NotNull String username, @NotNull String email, @NotNull String password,
                             @NotNull String phone, @NotNull String address

) {
}