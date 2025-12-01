package de.seuhd.campuscoffee.domain.impl;

import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.ports.UserDataService;
import de.seuhd.campuscoffee.domain.ports.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDataService data; // interface, Spring injects UserDataServiceImpl

    @Override
    public List<User> getAllUsers() {
        return data.getAll();
    }

    @Override
    public User getUserById(Long id) {
        return data.getById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return data.getByLoginName(login);
    }

    @Override
    public User createUser(User user) {
        User userWithTimestamps = user.toBuilder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return data.upsert(userWithTimestamps);
    }

    @Override
    public User updateUser(User user) {
        User userWithUpdated = user.toBuilder()
                .updatedAt(LocalDateTime.now())
                .build();

        return data.upsert(userWithUpdated);
    }

    @Override
    public void deleteUser(Long id) {
        data.delete(id);
    }
}
