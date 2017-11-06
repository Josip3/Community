package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.Music;
import ua.repository.MusicRepository;
import ua.service.MusicService;
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
}
