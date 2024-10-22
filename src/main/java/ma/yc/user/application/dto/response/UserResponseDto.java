package ma.yc.user.application.dto.response;

import jakarta.validation.constraints.NotNull;
import ma.yc.user.domain.valueObject.UserId;

public record UserResponseDto(
        @NotNull UserId userId,
        @NotNull String username,
        @NotNull String email,
        @NotNull String address)
{
}
