package ua.service;

import ua.entity.Photo;

import java.util.List;

public interface PhotoService {

    void save(Photo photo);

    List<Photo> findAll();

    Photo findOne(int id);

    void delete(int id);

    void setPhotoType(String photoType,int id);

    List<Photo> findByPhotoType(String photoType);

}
