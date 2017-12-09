package ua.request;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

    @Getter@Setter private String email;

    @Getter@Setter private String password;

    public LoginRequest(){}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
