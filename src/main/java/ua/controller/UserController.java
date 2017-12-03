package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.editor.CountryEditor;
import ua.entity.Country;
import ua.entity.User;
import ua.service.CountryService;
import ua.service.UserService;

import javax.validation.Valid;


@CrossOrigin
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    @InitBinder("user")
    protected  void initBuilder(WebDataBinder binder){
        binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
    }


    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String reg(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("country",countryService.findAll());
        return "registration";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "redirect:/reg";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute  User user){
        userService.save(user);
        return "redirect:/reg";
    }





}
