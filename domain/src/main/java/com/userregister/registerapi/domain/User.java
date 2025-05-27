package com.userregister.registerapi.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class User {
    private UUID id;
    private String name;
    private LocalDateTime timestamp;
}
