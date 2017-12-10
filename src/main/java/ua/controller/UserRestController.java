package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ua.entity.User;
import ua.request.LoginRequest;
import ua.restService.UserRestService;
import ua.security.TokenUtils;
import ua.service.UserService;
import ua.service.impl.UserDetailsServiceImpl;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/registration")
public class UserRestController {

    @Value("${lgs.token.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRestService userRestService;

//    @PreAuthorize("hasRole('USER_ROLE')")
    @RequestMapping(method = RequestMethod.PUT,value = "/save")
    public User register(@RequestBody User user){
        return userRestService.register(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity<?> authOnRequest(@RequestBody LoginRequest loginRequest){
        System.err.println(loginRequest.getEmail()+loginRequest.getPassword());
        Authentication authentication =
                this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getEmail());

        String token = this.tokenUtils.generateToken(userDetails);
        System.err.println(token + " token");
        return  ResponseEntity.ok(token);
    }





}
