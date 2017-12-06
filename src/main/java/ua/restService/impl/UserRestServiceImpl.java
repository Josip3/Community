package ua.restService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.entity.User;
import ua.entity.enums.UserRole;
import ua.repository.UserRepository;
import ua.restService.UserRestService;

import java.util.List;

@Service
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User register(User user) {
        user.setName(user.getName().toUpperCase());
        user.setEnabled(true);
        user.setRole(UserRole.ADMIN_ROLE);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean delete(Integer id) {
        userRepository.delete(id);
        return true;
    }
}
