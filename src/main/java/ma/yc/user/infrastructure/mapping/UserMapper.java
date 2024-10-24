package ma.yc.user.infrastructure.mapping;

import ma.yc.common.infrastructure.mapper.GenericMapper;
import ma.yc.user.application.dto.request.UserRequestDto;
import ma.yc.user.application.dto.response.UserResponseDto;
import ma.yc.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserResponseDto, User> {

    User toEntity(UserRequestDto dto);
    UserResponseDto toDto(User user);

}
