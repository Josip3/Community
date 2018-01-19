package ua.service;

import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.entity.User;

import java.util.List;

public interface UserService {

    User findOne(int id);

    void delete(int id);

    void save(User user);

    User saveImage(MultipartFile multipartFile, Integer id);

    void addMainPhoto(MultipartFile multipartFile, User user);

    List<User> findAlls();

    User findByEmail(String email);

    User update(User user);

    User updateName(User user);

    User updateLastName(User user);

    User updateAge(User user);

    User findByName(String name);

    List<Music> findAllMusic(Integer id);

    User addMusic(Integer idMusic,Integer idUser);

}
