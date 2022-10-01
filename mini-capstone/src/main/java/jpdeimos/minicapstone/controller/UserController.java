package jpdeimos.minicapstone.controller;

import jpdeimos.minicapstone.dto.UserDTO;
import jpdeimos.minicapstone.model.UserRequest;
import jpdeimos.minicapstone.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/signup")
    public UserDTO registerUser(@RequestBody @NonNull UserRequest userRequest) {
        return userService.saveUser(userRequest);
    }
}
