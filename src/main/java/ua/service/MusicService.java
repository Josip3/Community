package ua.service;

import ua.entity.Music;

import java.util.List;

public interface MusicService {

    void save(Music music);

    List<Music> findAll();

    Music findOne(int id);

    void delete(int id);
}
