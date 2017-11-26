package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.repository.UserRepository;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/cm",method = RequestMethod.GET)
    public String getUserPage(Model model, Principal principal){
    model.addAttribute("user",userRepository.findByName(principal.getName()));
        return "userPage";
    }


}
