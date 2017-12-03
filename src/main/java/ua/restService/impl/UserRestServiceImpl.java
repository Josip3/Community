package ua.restService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.User;
import ua.repository.UserRepository;
import ua.restService.UserRestService;

import java.util.List;

@Service
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User register(User user) {
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
