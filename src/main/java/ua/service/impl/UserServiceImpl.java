package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import ua.entity.User;
import ua.entity.enums.UserRole;
import ua.repository.UserRepository;
import ua.request.MyPageRequest;
import ua.service.UserService;


import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;


    public void save(User user) {
        user.setName(user.getName().toUpperCase());
        user.setEnabled(true);
        user.setRole(UserRole.ADMIN_ROLE);
        user.setPassword(encoder.encode(user.getPassword()));
        for (User email:
                ofNullable(findAlls()).orElse(new ArrayList<>())) {
            if(!user.getEmail().equals(email.getEmail()))
                userRepository.save(user);
            else
                throw new NullPointerException("Вже э такий");
        }



    }

    @Override
    public List<User> findAlls() {
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
    public Page<User> findAll(MyPageRequest page) {
        PageRequest pageRequest = new PageRequest(page.getNumberPage(),page.getNumberPage());
        return userRepository.findAll(pageRequest);
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

    //головне фото на сторінці юзера
    @Override
    public User findByEmail(String email) {
        return findAlls()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .get();
    }


}
