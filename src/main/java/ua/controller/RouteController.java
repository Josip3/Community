package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class RouteController {


    @Autowired
    private CountryService countryService;

    @InitBinder("user")
    protected  void initBuilder(WebDataBinder binder){
        binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
    }

    @RequestMapping(value = "/",    method = RequestMethod.GET)
    public String home(){
        return "redirect:/registration";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String getRegistrationPage(){
        return "registration";
    }




}
