package ua.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {

    public City(){}

    public City(String nameCity, Country country) {
        this.nameCity = nameCity;
        this.country = country;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter private int id;

    @Getter@Setter private String nameCity;

    @ManyToOne
    @Getter@Setter private Country country;



}
