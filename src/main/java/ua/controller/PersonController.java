package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.editor.CityEditor;
import ua.entity.City;
import ua.entity.User;
import ua.service.CityService;
import ua.service.UserService;

@Controller
public class PersonController {

    @Autowired
    UserService userRepository;

    @Autowired
    CityService cityRepository;

    @InitBinder("user")
    protected void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(City.class,new CityEditor(cityRepository));
    }

    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public String showCity(Model model){
        model.addAttribute("user",new User());
    return "city";
     }
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public String showCity(@ModelAttribute User user){
        userRepository.save(user);
        return "city";
    }




}
