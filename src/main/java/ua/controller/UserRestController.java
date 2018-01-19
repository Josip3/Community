package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.entity.User;
import ua.service.UserService;
import ua.service.restService.UserRestService;
import ua.service.utils.FileBuilder;

import java.security.Principal;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/registration")
public class UserRestController {

    @Value("${lgs.token.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRestService userRestService;

    @Autowired
    private UserService userService;

    @GetMapping("/my-music/{id}")
    private ResponseEntity<List<Music>> mymusic(@PathVariable Integer id){
        return new ResponseEntity<>(userService.findAllMusic(id),HttpStatus.OK);
    }

    @PostMapping("/add-music")
    private ResponseEntity<User> addMusic(@RequestParam Integer idUser,@RequestParam Integer idMusic){
        return new ResponseEntity<>(userService.addMusic(idMusic,idUser),HttpStatus.OK);
    }

    // ResponseEntity<User> обгортка для респонсу (в даному випадку відправляє юзера і статус 200(ОК))
    // Анотація, щоб на писати метод, тільки мапування
    @PostMapping("/save")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userRestService.register(user), OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(userRestService.delete(id), OK);
    }


    @PostMapping("/update")
    private ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), OK);
    }

    @PostMapping("/update/name")
    private ResponseEntity<User> updateName(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateName(user), OK);
    }

    @PostMapping("/update/last-name")
    private ResponseEntity<User> updateLastName(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateLastName(user), OK);
    }

    @PostMapping("/update/age")
    private ResponseEntity<User> updateAge(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateAge(user), OK);
    }

    @GetMapping("/get-user")
    private ResponseEntity<User> getUser(Principal principal) {
        System.err.println("-------------------------------");
        System.err.println(ofNullable(principal).isPresent());
        System.err.println("-------------------------------");
        System.err.println("principal " + ofNullable(principal.getName()).orElse("null"));
        return new ResponseEntity<>(userService.findByEmail(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/save-image/{id}")
    private ResponseEntity<User> saveImage(@RequestParam MultipartFile multipartFile, @PathVariable Integer id) {
        return new ResponseEntity<>(userService.saveImage(multipartFile, id), OK);
    }

}
