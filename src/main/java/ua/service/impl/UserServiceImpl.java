package ua.service.impl;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.User;
import ua.entity.enums.UserRole;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
//        user.setName(user.getName().toUpperCase());
        user.setEnabled(true);
        user.setRole(UserRole.ADMIN_ROLE);
        user.setPassword(encoder.encode(user.getPassword()));
        for (User email:
             findAll()) {
            if(!user.getEmail().equals(email.getEmail()))
                userRepository.save(user);
            else
                throw new NullPointerException("Вже э такий");
        }



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

    @Override
    public void updateAge(int id, int age) {
        User user = findOne(id);
        user.setAge(age);
        userRepository.save(user);
    }

    @Override
    public void addMainPhoto(MultipartFile multipartFile, User user) {
//        String path = System.getProperty("catalina.home") + "/resources/"
//                + user.getName() + "/" + multipartFile.getOriginalFilename();
//
//        user.setMainPhoto("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());
//
//        File file = new File(path);
//
//        try {
//            file.mkdirs();
//            try {
//                FileUtils.cleanDirectory
//                        (new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            multipartFile.transferTo(file);
//            userRepository.save(user);
//        } catch (IOException e) {
//            System.out.println("error with file");
//        }

    }

    @Override
    public User findByEmail(String email) {
        return findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }


}
