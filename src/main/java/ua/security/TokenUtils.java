package ua.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    @Value("${lgs.token.secret}")
    private String secret;

    @Value("{token.expired}")
    private String expired;


    //щоб з токена витягнути юзернейм(логин)
    public String getUsernameFromToken(String token){
        String username;
        try {
            final Claims claims = this.getClaimsFromToken(token);
              username = (String) claims.get("sub");
              System.out.println("TRUE");
        }catch (Exception e){
            username = null;
            System.out.println("FALSE");
            e.printStackTrace();
        }
        return username;
    }

    public Date getCreatedDateFromToken(String token){
        Date created;

        try {
            final Claims claims = this.getClaimsFromToken(token);
            created = new Date((Long) claims.get("created"));
        }catch (Exception e){
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            expiration = claims.getExpiration();
        }catch (Exception e){
            expiration = null;
        }
        return expiration;

    }

    private Claims getClaimsFromToken(String token){
        Claims claims;
        System.out.println(token + " token");
        try {

            claims =Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
            System.out.println(Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token));
        } catch (Exception e){
            claims = null;
//            e.printStackTrace();
        }
        return claims;
    }

    private Date generationCurrentDate(){
        return new Date();
    }

    private Date generationExpirationDate(){
        return new Date(System.currentTimeMillis() + 1000 * 10000);
    }

    private Boolean isTokenExpired(String token){
        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(this.generationCurrentDate());
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<String, Object>();
        claims.put("sub", userDetails.getUsername() );
        claims.put("created",this.generationCurrentDate());
        return this.generateToken(claims);
    }

    private String generateToken(Map<String,Object> claims){
        return Jwts.builder().setClaims(claims).setExpiration(this.generationExpirationDate())
                .signWith(SignatureAlgorithm.HS512,this.secret).compact();
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        User user = (User) userDetails;
        final String username = this.getUsernameFromToken(token);
        return (username.equals(user.getEmail())) && !(this.isTokenExpired(token));
    }
}
