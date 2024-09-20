package ru.vovk.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vovk.springboot.repository.UserRepository;
import ru.vovk.springboot.model.User;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User maybeUser = new User();
        maybeUser.setId(user.getId());
        maybeUser.setUsername(user.getUsername());
        maybeUser.setEmail(user.getEmail());
        maybeUser.setRole(user.getRole());
        maybeUser.setCreateDate(user.getCreateDate());
        repository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User maybeUser = getUserById(id)
                .orElseThrow();
        maybeUser.setUsername(user.getUsername());
        maybeUser.setEmail(user.getEmail());
        maybeUser.setRole(user.getRole());
        maybeUser.setCreateDate(user.getCreateDate());
        repository.save(maybeUser);
    }

    @Override
    public void updateUser(Long id, String username, String email) {
        User maybeUser = getUserById(id)
                .orElseThrow();
        maybeUser.setUsername(username);
        maybeUser.setEmail(email);
        maybeUser.setRole(maybeUser.getRole());
        maybeUser.setCreateDate(maybeUser.getCreateDate());
        repository.save(maybeUser);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
