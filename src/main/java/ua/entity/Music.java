package ua.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Music")

public class Music {

    public Music(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter@Getter private int id;

    @Getter@Setter private String perfomerName;

    @Getter@Setter private String trackName;

    @Getter@Setter
    @Column(name = "music_file")
    private String musicFile;

    @ManyToMany
    @JoinTable(name = "MUSIC_FROM_USER",joinColumns = @JoinColumn(name = "ID_MUSIC"),inverseJoinColumns = @JoinColumn(name = "ID_USER"))
    @Getter@Setter private List<User> userMusicList;

    @ManyToMany
    @JoinTable(name = "POST_FROM_MUSIC",joinColumns = @JoinColumn(name = "id_music"),inverseJoinColumns = @JoinColumn(name = "id_post"))
    @Getter@Setter private List<Post> musicList;

    @ManyToOne
    @Getter@Setter private GanreMusic ganreMusic;

}
