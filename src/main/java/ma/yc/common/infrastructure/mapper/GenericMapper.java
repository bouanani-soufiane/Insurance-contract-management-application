package ma.yc.common.infrastructure.mapper;

public interface GenericMapper<Entity, RequestDto , ResponseDto> {
    Entity toEntity ( RequestDto dto );
    ResponseDto toDto ( Entity entity );
}
