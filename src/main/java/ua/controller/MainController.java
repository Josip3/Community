package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.User;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/saveImage")
    public String saveImage(Principal principal, @RequestParam MultipartFile image) {
        userService.addMainPhoto(image, userRepository.findByName(principal.getName()));
        return "redirect:/community";
    }

}
