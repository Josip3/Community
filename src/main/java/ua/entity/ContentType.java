package ua.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Content_Type")
public class ContentType {

    public ContentType(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter@Getter private int id;

    @Setter@Getter private String nameCategory;
}
