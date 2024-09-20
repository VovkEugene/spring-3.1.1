package ru.vovk.springboot.service;

import ru.vovk.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void saveUser(User user);

    void updateUser(Long id, String username, String email);

    void deleteUser(Long id);
}
