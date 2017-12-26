package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ua.entity.User;
import ua.service.UserService;
import ua.service.restService.UserRestService;

import java.security.Principal;

import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/registration")
public class UserRestController {

    @Value("${lgs.token.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRestService userRestService;

    @Autowired
    private UserService userService;

    // ResponseEntity<User> обгортка для респонсу (в даному випадку відправляє юзера і статус 200(ОК))
// Анотація, щоб на писати метод, тільки мапування
    @PostMapping("/save")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userRestService.register(user), OK);
    }

//    @RequestMapping(method = RequestMethod.POST,value = "/login")
//    public ResponseEntity<?> authOnRequest(@RequestBody LoginRequest loginRequest){
//       //о це вроді не робить
//         Authentication authentication =
//                this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getEmail());
//        String token = this.tokenUtils.generateToken(userDetails);
//        System.err.println("USER REST CONTROLLER : : 'authOnRequest' " + token + " token");
//        System.err.println("USER REST CONTROLLER : : 'authOnRequest' " + loginRequest.getEmail()+loginRequest.getPassword());
//        return  ResponseEntity.ok(token);
//    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(userRestService.delete(id), OK);
    }


    @PostMapping("/update")
    private ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), OK);
    }

    @PostMapping("/update/name")
    private ResponseEntity<User> updateName(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateName(user), OK);
    }

    @PostMapping("/update/last-name")
    private ResponseEntity<User> updateLastName(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateLastName(user), OK);
    }

    @PostMapping("/update/age")
    private ResponseEntity<User> updateAge(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateAge(user), OK);
    }

    @GetMapping("/get-user")
    private ResponseEntity<User> getUser(Principal principal) {
        System.err.println("-------------------------------");
        System.err.println(ofNullable(principal).isPresent());
        System.err.println("-------------------------------");
        System.err.println("principal " + ofNullable(principal.getName()).orElse("null"));
        return new ResponseEntity<>(userService.findByEmail(principal.getName()), HttpStatus.OK);
    }

}
