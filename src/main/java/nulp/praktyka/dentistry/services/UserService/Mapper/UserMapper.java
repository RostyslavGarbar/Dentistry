package nulp.praktyka.dentistry.services.UserService.Mapper;

import nulp.praktyka.dentistry.domains.Users;
import nulp.praktyka.dentistry.services.UserService.Dto.UserDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDtoResponse toDto(Users users);

}
