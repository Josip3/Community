package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.entity.User;
import ua.entity.enums.Role;
import ua.repository.MusicRepository;
import ua.repository.UserRepository;
import ua.service.UserService;
import ua.service.utils.FileBuilder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private FileBuilder fileBuilder;


    public void save(User user) {
        user.setName(user.getName().toUpperCase());
        user.setEnabled(true);
        user.setRole(Role.ROLE_USER);
        user.setMainPhoto("/assets/image/cat.jpg");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new NullPointerException("Вже э такий");
        else
            userRepository.save(user);

    }

    @Override
    public User saveImage(MultipartFile multipartFile, Integer id) {
        User user = findOne(id);
        user.setMainPhoto(fileBuilder.saveFile(multipartFile));
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (userRepository.findOne(user.getId()) != null)
            return userRepository.save(user);
        return null;
    }

    @Override
    public User updateName(User user) {
        return update(userRepository.findOne(user.getId()).setName(user.getName()));
    }

    @Override
    public User updateLastName(User user) {
        return update(userRepository.findOne(user.getId()).setLastName(user.getLastName()));
    }

    @Override
    public User updateAge(User user) {
        return update(userRepository.findOne(user.getId()).setAge(user.getAge()));
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
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<Music> findAllMusic(Integer id) {
        return userRepository.findAllMusic(id);
    }

    @Override
    public User addMusic(Integer idMusic, Integer idUser) {
        User user = userRepository.findOne(idUser);
        List<Music> music = user.getMusicList();
        if(music.stream().noneMatch(music1 -> music1.getId()==idMusic))
        music.add(musicRepository.findOne(idMusic));
        return userRepository.save(user.setMusicList(music));
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
        return userRepository.findByEmail(email);
    }


}
