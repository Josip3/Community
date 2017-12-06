package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.entity.User;
import ua.restService.UserRestService;
import ua.service.UserService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/registration")
public class UserRestController {

    @Autowired
    private UserRestService userRestService;


    @RequestMapping(method = RequestMethod.PUT)
    public User register(@RequestBody User user){
        return userRestService.register(user);
    }


}
