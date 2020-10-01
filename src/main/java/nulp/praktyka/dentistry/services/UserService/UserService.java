package nulp.praktyka.dentistry.services.UserService;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.repositories.UserRepository;
import nulp.praktyka.dentistry.services.UserService.Dto.UserDtoLogin;
import nulp.praktyka.dentistry.services.UserService.Dto.UserDtoResponse;
import nulp.praktyka.dentistry.services.UserService.Mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDtoResponse login(UserDtoLogin userDtoLogin) {
        return userMapper.toDto(userRepository.findByLoginAndPassword(
                userDtoLogin.getLogin(), userDtoLogin.getPassword()));
    }
}
