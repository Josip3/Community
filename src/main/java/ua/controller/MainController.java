package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.repository.UserRepository;
import ua.service.UserService;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/community",method = RequestMethod.GET)
    public String getUserPage(Model model, Principal principal){
    model.addAttribute("user",userRepository.findByName(principal.getName()));
        return "userPage";
    }

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public String saveImage(Principal principal,@RequestParam MultipartFile image){
        userService.addMainPhoto(image, userRepository.findByName(principal.getName()));

        return "redirect:/community";
    }
    @RequestMapping(value="/id{id}", method = RequestMethod.GET)
    public String findById(Model model, @PathVariable int id){
        model.addAttribute("user",userService.findOne(id));
        return "userPage";
    }

}
