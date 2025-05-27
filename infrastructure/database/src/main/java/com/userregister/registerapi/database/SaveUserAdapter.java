package com.userregister.registerapi.database;

import com.userregister.registerapi.domain.SaveUserPort;
import com.userregister.registerapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserAdapter implements SaveUserPort {

    private final UserRepository userRepository;
    @Override
    public void create(User user) {
        userRepository.insert(user);
    }
}
