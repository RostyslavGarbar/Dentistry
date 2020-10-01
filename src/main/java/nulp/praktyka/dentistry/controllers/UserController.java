package nulp.praktyka.dentistry.controllers;

import lombok.RequiredArgsConstructor;
import nulp.praktyka.dentistry.services.UserService.Dto.UserDtoLogin;
import nulp.praktyka.dentistry.services.UserService.Dto.UserDtoResponse;
import nulp.praktyka.dentistry.services.UserService.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public UserDtoResponse login(@RequestBody UserDtoLogin userDtoLogin) {
        return userService.login(userDtoLogin);
    }
}
