package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private UserService userService;


    @RequestMapping(value = "/login/admin",method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("users",userService.findAlls());
        return "adminPage";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/login/admin";
    }



}
