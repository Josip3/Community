package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ua.entity.User;
import ua.request.delete;
import ua.service.UserService;
import ua.service.restService.UserRestService;

import static org.springframework.http.HttpStatus.OK;


@CrossOrigin
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


    @PutMapping("/save")
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


    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody delete request) {
        return new ResponseEntity<>(userRestService.delete(request.getId()), OK);
    }


    @PutMapping("/update")
    private ResponseEntity<User> update(@RequestBody User user) {
        return new ResponseEntity<>(userService.update(user), OK);
    }


}
