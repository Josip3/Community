package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.entity.User;
import ua.service.UserService;

@Controller
public class RouteController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
         return "home";
    }

    @RequestMapping(value = "/login/admin",method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("users",userService.findAll());
        return "adminPage";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/login/admin";
    }AS

    @RequestMapping(value = "/update/name/{id}", method = RequestMethod.GET)
    public String updateName(@PathVariable Integer id,@ModelAttribute String name){
        userService.updateName(id,name);
        return "redirect:/login/admin";
    }

    @RequestMapping(value = "/update/surname/{id}",method = RequestMethod.GET)
    public String updateSurname(@PathVariable Integer id,@ModelAttribute String surname){
        userService.updateSurname(id,surname);
        return "redirect:/login/admin";
    }

    @RequestMapping(value ="/update/age/{id}",method = RequestMethod.GET)
    public String updateAge(@PathVariable int id,@ModelAttribute int age){
        userService.updateAge(id,age);
        return "redirect:/login/admin";
    }

    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String reg(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/reg";
    }


}
