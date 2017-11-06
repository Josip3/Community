package ua.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter private int id;

    @Getter@Setter private String message;

    @Getter@Setter private LocalDateTime messageTime;

    @ManyToMany
    @JoinTable(name = "USER_MESSAGE",joinColumns = @JoinColumn(name = "ID_MESSAGE"),inverseJoinColumns = @JoinColumn(name = "ID_USER"))
    @Getter@Setter private List<User> users = new ArrayList<>();
}
