package ua.restService;

import ua.entity.User;

import java.util.List;

public interface UserRestService {



        User register(User user);

//        boolean login(LoginRequest loginRequest);

        List<User> findAll();

        boolean delete(Integer id);

}
