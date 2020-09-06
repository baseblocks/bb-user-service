package tech.baseblocks.dataencryption.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tech.baseblocks.dataencryption.dto.UserDto;
import tech.baseblocks.dataencryption.model.User;

@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget User user, UserDto userDto);
}