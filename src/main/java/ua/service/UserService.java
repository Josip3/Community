package ua.service;

import org.springframework.web.multipart.MultipartFile;
import ua.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void updateName(int id,String name);

    void updateSurname(int id,String surname);

    void updateAge(int id,int age);

    void addMainPhoto(MultipartFile multipartFile, User user);

    User findByEmail(String email);



}
