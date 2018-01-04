package ua.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.repository.MusicRepository;
import ua.service.MusicService;

import java.io.IOException;
import java.util.List;


@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void save(MultipartFile file, Music music) {
        music.setMusicFile(encodeToBase64(file));
        save(music);
    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findOne(int id) {
        return musicRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }

    @Override
    public String encodeToBase64(MultipartFile file) {
            String encodedFile = null;
            byte[] bytes = new byte[(int) file.getSize()];
            try {
                bytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            encodedFile = Base64.encodeBase64String(bytes);
            return encodedFile;

    }
}
