package com.userregister.registerapi.web;

import com.userregister.registerapi.domain.SaveUserUseCase;
import com.userregister.registerapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class Controller {

    private final SaveUserUseCase saveUserUseCase;

    @PostMapping("/users")
    public void create(@RequestBody User user) {
        saveUserUseCase.create(user);
    }

    @GetMapping("/test")
    public String test() {
        return "Successfully deployed!";
    }
}
