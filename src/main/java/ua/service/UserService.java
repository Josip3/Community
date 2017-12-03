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

    Page<User> findAll(MyPageRequest myPageRequest);

    void addMainPhoto(MultipartFile multipartFile, User user);



}
