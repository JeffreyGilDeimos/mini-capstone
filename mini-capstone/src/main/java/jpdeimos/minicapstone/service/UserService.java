package jpdeimos.minicapstone.service;

import jpdeimos.minicapstone.dto.UserDTO;
import jpdeimos.minicapstone.model.UserRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    public UserDTO saveUser(@NonNull UserRequest newUser) {
        return null;
    }

}
