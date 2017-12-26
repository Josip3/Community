package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.User;
import ua.request.MyPageRequest;

import java.util.List;

public interface UserService {

    User findOne(int id);

    void delete(int id);

    void save(User user);

    List<User> findAlls();

    User findByEmail(String email);

    void addMainPhoto(MultipartFile multipartFile, User user);

    User update(User user);

    User updateName(User user);

    User updateLastName(User user);

    User updateAge(User user);

    User findByName(String name);

}
