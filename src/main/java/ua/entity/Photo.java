package ua.entity;


import lombok.Getter;
import lombok.Setter;
import ua.entity.enums.TypePhoto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User_Photo")
public class Photo {

    public Photo(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter private int id;

    @Setter@Getter private String photoURL;

    @Enumerated
    @Setter@Getter private TypePhoto typePhoto;

    @ManyToMany
    @Getter@Setter private List<User> userPhotoList = new ArrayList<User>();

    @ManyToMany
    @Getter@Setter private List<Post> photoList;
}
