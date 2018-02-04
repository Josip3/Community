package ua.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.entity.Music;
import ua.repository.MusicRepository;
import ua.service.MusicService;
import ua.service.utils.FileBuilder;

import java.io.IOException;
import java.util.List;


@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private FileBuilder fileBuilder;

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public Music save(MultipartFile file, Integer id) {
        Music music = musicRepository.findOne(id);
        music.setMusicFile(fileBuilder.saveFile(file));
        return musicRepository.save(music);

    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }


    @Override
    public Music findOne(Integer id) {
        return musicRepository.findOne(id);
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null || id >= 0) {
            try {
                musicRepository.delete(musicRepository.findOne(id));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            throw new UnknownError();
        }
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
