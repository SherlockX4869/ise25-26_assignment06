package de.seuhd.campuscoffee.domain.ports;

import de.seuhd.campuscoffee.domain.model.User;
import java.util.List;
import jakarta.validation.constraints.NotNull;

/**
 * Port interface for user data operations.
 */
public interface UserDataService {

    void clear();

    @NotNull
    List<User> getAll();

    @NotNull
    User getById(@NotNull Long id);

    @NotNull
    User getByLoginName(@NotNull String loginName);

    @NotNull
    User upsert(@NotNull User user);

    void delete(@NotNull Long id);
}
