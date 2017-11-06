package ua.service;

import ua.entity.GanreMusic;

import java.util.List;

public interface GanreService {

    void save(GanreMusic ganreMusic);

    List<GanreMusic> findAll();

    GanreMusic findOne(int id);

    void delete(int id);
}
