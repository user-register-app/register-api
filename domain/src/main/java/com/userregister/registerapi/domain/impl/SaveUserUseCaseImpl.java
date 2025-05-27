package com.userregister.registerapi.domain.impl;

import com.userregister.registerapi.domain.SaveUserPort;
import com.userregister.registerapi.domain.SaveUserUseCase;
import com.userregister.registerapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserUseCaseImpl implements SaveUserUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void create(User user) {
        saveUserPort.create(user);
    }
}
