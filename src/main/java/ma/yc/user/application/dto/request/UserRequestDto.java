package ma.yc.user.application.dto.request;

import jakarta.validation.constraints.NotNull;
import ma.yc.user.domain.valueObject.UserId;

public record UserRequestDto(
        @NotNull String username,
        @NotNull String email,
        @NotNull String password,
        @NotNull String address)
{
}
