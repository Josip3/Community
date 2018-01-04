package ua.service;

import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;

import java.util.List;

public interface MusicService {

    void save(Music music);

    void save(MultipartFile file,Music music);

    List<Music> findAll();

    Music findOne(int id);

    void delete(int id);

    String encodeToBase64(MultipartFile file);
}
