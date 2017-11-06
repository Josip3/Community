package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.Photo;
import ua.entity.enums.TypePhoto;
import ua.repository.PhotoRepository;
import ua.service.PhotoService;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Photo findOne(int id) {
        return photoRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        photoRepository.delete(id);
    }

    @Override
    public void setPhotoType(String photoType,int id) {
       Photo photo = findOne(id);
              photo.setTypePhoto(TypePhoto.valueOf(photoType));
              save(photo);
    }

    @Override
    public List<Photo> findByPhotoType(String photoType) {
        if(photoType == null){
            throw  new NullPointerException("ty debil, photoType == null");
        }
       return ofNullable(findAll()).orElse(new ArrayList<>()).stream()
               .filter(photo -> photo.getTypePhoto().equals(TypePhoto.valueOf(photoType)))
               .collect(Collectors.toList());
    }


}
