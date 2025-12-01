package de.seuhd.campuscoffee.api.user;

import de.seuhd.campuscoffee.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;

        return new UserDto(
                user.id(),
                user.createdAt(),
                user.updatedAt(),
                user.login(),
                user.email(),
                user.firstName(),
                user.lastName()
        );
    }

    public User toDomain(UserDto dto) {
        if (dto == null) return null;

        return User.builder()
                .id(dto.getId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .login(dto.getLogin())
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }
}
