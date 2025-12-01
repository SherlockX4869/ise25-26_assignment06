package de.seuhd.campuscoffee.domain.ports;

import de.seuhd.campuscoffee.domain.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByLogin(String login);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
