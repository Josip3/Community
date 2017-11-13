package ua.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ToString
@Entity
@Table(name = "_USER_")
public class User {

    //paternMVC
    //JAVA8//stream

    public User(){}

    public User(String name, String lastName, int age, String phoneNumber, String email, LocalDateTime dateOfBirth, String address, String password, Country country, List<Group> groupList, List<Music> musicList, List<Photo> photoList, List<Message> messageList, List<Post> postList) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
        this.country = country;
        this.groupList = groupList;
        this.musicList = musicList;
        this.photoList = photoList;
        this.messageList = messageList;
        this.postList = postList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter private int id;

    @Getter@Setter private String name;

    @Getter@Setter private String lastName;

    @Getter@Setter private int age;

    @Getter@Setter private String phoneNumber;

    @Getter@Setter private String email;

    @Getter@Setter private LocalDateTime dateOfBirth;

    @Getter@Setter private String address;

    @Getter@Setter private String password;


    @ManyToOne
    @Getter@Setter private Country country;

    @ManyToMany
    @JoinTable(name = "GROUP_FROM_USER",joinColumns = @JoinColumn(name = "ID_USER"),inverseJoinColumns = @JoinColumn(name = "ID_GROUP"))
    @Getter@Setter private List<Group> groupList;

    @ManyToMany
    @JoinTable(name = "MUSIC_FROM_USER",joinColumns = @JoinColumn(name = "ID_USER"),inverseJoinColumns = @JoinColumn(name = "ID_MUSIC"))
    @Getter@Setter private List<Music> musicList;

    @ManyToMany
    @JoinTable(name = "PHOTO_FROM_USER",joinColumns = @JoinColumn(name = "ID_USER"),inverseJoinColumns = @JoinColumn(name = "ID_PHOTO"))
    @Getter@Setter private List<Photo> photoList;

    @ManyToMany
    @JoinTable(name = "USER_MESSAGE",joinColumns = @JoinColumn(name = "ID_USER"),inverseJoinColumns = @JoinColumn(name = "ID_MESSAGE"))
    @Getter@Setter private List<Message> messageList;

    @OneToMany(mappedBy = "user")
    @Getter@Setter private List<Post> postList;


}
