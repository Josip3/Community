package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import ua.editor.CountryEditor;
import ua.entity.Country;
import ua.service.CountryService;


@Controller
public class RouteController {


    @Autowired
    private CountryService countryService;

    @InitBinder("user")
    protected void initBuilder(WebDataBinder binder) {
        binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
    }

    @GetMapping("/")
    public String home() {
//        return "redirect:/registration";
        return "front/dist/index";
    }

//    @GetMapping("/registration")
//    public String getRegistrationPage() {
//        return "registration";
//    }


}
