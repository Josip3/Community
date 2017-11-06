package ua.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Post")
public class Post {

    public Post(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @Getter@Setter private LocalDateTime timeOfPosting;

    @Getter@Setter private int likes;

    @Setter@Getter private String text;

    @ManyToOne
    @Getter@Setter private User user;

    @ManyToMany
    @JoinTable(name = "POST_FROM_MUSIC",joinColumns = @JoinColumn(name = "id_post"),inverseJoinColumns = @JoinColumn(name = "id_music"))
    @Getter@Setter private List<Music> musicList;

    @ManyToMany
    @JoinTable(name = "POST_FROM_PHOTO",joinColumns = @JoinColumn(name = "id_post"),inverseJoinColumns = @JoinColumn(name = "id_photo"))
    @Getter@Setter private List<Photo> photoList;

    @ManyToOne
    @Getter@Setter private Group group;

}
