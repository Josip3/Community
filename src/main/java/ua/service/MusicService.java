package ua.service;

import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;

import java.util.List;

public interface MusicService {

    Music save(Music music);

    Music save(MultipartFile file,Integer id);

    List<Music> findAll();

    Music findOne(Integer id);

    void delete(Integer id);

    String encodeToBase64(MultipartFile file);
}
