package ua.security;


import com.mysql.jdbc.log.Log;
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
            username = claims.getSubject();
        }catch (Exception e){
            username = null;
        }
        return username;
    }

    //
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
        try {
            claims = (Claims) Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
        } catch (Exception e){
            claims = null;
        }
        return claims;
    }

    private Date generationCurrentDate(){
        return new Date();
    }

    private Date generationExpirationDate(){
        System.out.println( new Date(System.currentTimeMillis()  * 10000));
        return new Date(System.currentTimeMillis()  * 10000);
    }

    private Boolean isTokenExpired(String token){
        System.err.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFUCK");
        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(this.generationCurrentDate());
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<String, Object>();
        claims.put("sub", userDetails.getUsername());
        claims.put("created",this.generationCurrentDate());
        return this.generateToken(claims);
    }

    private String generateToken(Map<String,Object> claims){
        return Jwts.builder().setClaims(claims).setExpiration(this.generationExpirationDate())
                .signWith(SignatureAlgorithm.HS512,"AHEET-GOVNO-BLET").compact();
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        User user = (User) userDetails;
        final String username = this.getUsernameFromToken(token);
        return (username.equals(user.getEmail())) && (this.isTokenExpired(token));
    }
}
