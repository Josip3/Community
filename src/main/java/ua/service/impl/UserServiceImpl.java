package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.User;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        user.setName(user.getName().toUpperCase());
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public void updateName(int id, String name) {
        User user = findOne(id);
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public void updateSurname(int id, String surname) {
        User user = findOne(id);
        user.setLastName(surname);
        userRepository.save(user);
    }


}
