package com.userregister.registerapi.domain.impl;

import com.userregister.registerapi.domain.SaveUserUseCase;
import com.userregister.registerapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserUseCaseImpl implements SaveUserUseCase {

    @Override
    public void create(User user) {
        System.out.println("created");
    }
}
