package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.service.UserService;

@Controller
public class AdminController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login/admin",method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("users",userService.findAll());
        return "adminPage";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/login/admin";
    }

    @RequestMapping(value = "/update/name/{id}", method = RequestMethod.POST)
    public String updateName(@PathVariable Integer id,String name){
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

}
