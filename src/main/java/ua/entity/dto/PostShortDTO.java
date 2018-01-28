package ua.entity.dto;

import java.time.LocalDateTime;

public class PostShortDTO {


    protected int id;
    protected LocalDateTime timeOfPosting;
    protected int likes;
    protected String text;

    public int getId() {
        return id;
    }

    public PostShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getTimeOfPosting() {
        return timeOfPosting;
    }

    public PostShortDTO setTimeOfPosting(LocalDateTime timeOfPosting) {
        this.timeOfPosting = timeOfPosting;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public PostShortDTO setLikes(int likes) {
        this.likes = likes;
        return this;
    }

    public String getText() {
        return text;
    }

    public PostShortDTO setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "PostShortDTO{" +
                "id=" + id +
                ", timeOfPosting=" + timeOfPosting +
                ", likes=" + likes +
                ", text='" + text + '\'' +
                '}';
    }
}
