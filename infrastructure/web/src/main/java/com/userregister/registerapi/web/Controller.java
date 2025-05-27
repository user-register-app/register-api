package com.userregister.registerapi.web;

import com.userregister.registerapi.domain.SaveUserUseCase;
import com.userregister.registerapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final SaveUserUseCase saveUserUseCase;

    @PostMapping("/users")
    public void create(@RequestBody User user) {
        saveUserUseCase.create(user);
    }
}
