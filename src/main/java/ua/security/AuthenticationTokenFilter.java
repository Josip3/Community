//package ua.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import ua.service.impl.UserDetailsServiceImpl;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
////фільтер
//@Component
//public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
//
//
//    @Value("${lgs.token.header}")
//    private String tokenHeader;
//
//    @Autowired
//    private TokenUtils tokenUtils;
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//        super.setAuthenticationManager(authenticationManager);
//    }
//
//    //перевірка при кожному запиті
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        String authToken = httpRequest.getHeader(this.tokenHeader);
//        String username = this.tokenUtils.getUsernameFromToken(authToken);
//        System.err.println("auth token"+authToken);
//        System.err.println("user name"+username);
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//            System.err.println("first if");
//            if (this.tokenUtils.validateToken(authToken, userDetails)) {
//                System.err.println("first if");
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}