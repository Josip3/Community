package ua.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
public class Country {

    public Country(){}

    public Country(String nameCountry, List<User> users, List<City> cities) {
        this.nameCountry = nameCountry;
        this.users = users;
        this.cities = cities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter@Getter private int id;

    @Getter@Setter private String nameCountry;

    @OneToMany(mappedBy = "userCountry")
    @Getter@Setter private List<User> users;

    @OneToMany(mappedBy = "country")
    @Getter@Setter private List<City> cities;


}
