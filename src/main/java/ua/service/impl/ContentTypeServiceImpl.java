package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.ContentType;
import ua.repository.ContentTypeRepository;
import ua.service.ContentTypeService;

import java.util.List;

@Service
public class ContentTypeServiceImpl implements ContentTypeService{

    @Autowired
    private ContentTypeRepository contentTypeRepository;

    @Override
    public void save(ContentType commodity) {
        contentTypeRepository.save(commodity);
    }

    @Override
    public List<ContentType> findAll() {
        return contentTypeRepository.findAll();
    }

    @Override
    public ContentType findOne(int id) {
        return contentTypeRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        contentTypeRepository.delete(id);
    }
}
