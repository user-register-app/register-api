package com.userregister.registerapi.database;

import com.userregister.registerapi.database.jooq.Tables;
import com.userregister.registerapi.database.jooq.tables.records.UsersRecord;
import com.userregister.registerapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserRepository {

    private final DSLContext dslContext;

    public void insert(User user) {
        dslContext.insertInto(Tables.USERS)
                .set(new UsersRecord() {{
                    setName(user.getName());
                    setTimestamp(LocalDateTime.now());
                }})
                .execute();
    }
}
