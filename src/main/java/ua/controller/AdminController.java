package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.entity.User;
import ua.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;


    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.findAlls(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/admin/get-all-users";
    }



}
