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

    //енами як номера
    @Enumerated
    @Setter@Getter private TypePhoto typePhoto;

    @ManyToMany
    @JoinTable(name = "PHOTO_FROM_USER",joinColumns = @JoinColumn(name = "ID_PHOTO"),inverseJoinColumns = @JoinColumn(name = "ID_USER"))
    @Getter@Setter private List<User> userPhotoList = new ArrayList<User>();

    @ManyToMany
    @JoinTable(name = "POST_FROM_PHOTO",joinColumns = @JoinColumn(name = "id_photo"),inverseJoinColumns = @JoinColumn(name = "id_post"))
    @Getter@Setter private List<Post> photoList;
}
