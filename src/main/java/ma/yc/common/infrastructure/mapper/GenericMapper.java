package ma.yc.common.infrastructure.mapper;

public interface GenericMapper<Entity, Dto> {
    Entity toEntity ( Dto dto );
    Dto toDto ( Entity entity );
}
