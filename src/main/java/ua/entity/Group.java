package ua.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "_Group")
public class Group {

    public Group(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter@Getter private int id;

    @Setter@Getter private String nameGroup;

    @Getter@Setter private int idMusic;

    @ManyToOne
    @Getter@Setter private ContentType contentType;

    @ManyToMany
    private List<User> groupList;

    @OneToMany(mappedBy = "group")
    @Getter@Setter private List<Post> postList;



}
