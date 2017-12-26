package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.editor.CountryEditor;
import ua.entity.Country;
import ua.service.CountryService;


@CrossOrigin
@Controller
public class RouteController {


    @Autowired
    private CountryService countryService;

    @InitBinder("user")
    protected void initBuilder(WebDataBinder binder) {
        binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
//        return "redirect:/registration";
        return "front/dist/index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }


}
