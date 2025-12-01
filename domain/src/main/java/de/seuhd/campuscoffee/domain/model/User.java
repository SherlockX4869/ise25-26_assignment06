package de.seuhd.campuscoffee.domain.model;

import lombok.Builder;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record User(
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String login,
        String email,
        String firstName,
        String lastName
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
