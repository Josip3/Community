package ua.service;

import ua.entity.ContentType;

import java.util.List;

public interface ContentTypeService {

    ContentType save(ContentType contentType);

    List<ContentType> findAll();

    ContentType findOne(int id);

    void delete(int id);
}
