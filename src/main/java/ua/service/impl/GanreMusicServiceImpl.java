package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.GanreMusic;
import ua.repository.GanreMusicRepository;
import ua.service.GanreService;

import java.util.List;

@Service
public class GanreMusicServiceImpl implements GanreService {

    @Autowired
    private GanreMusicRepository ganreMusicRepository;

    @Override
    public void save(GanreMusic ganreMusic) {
        ganreMusicRepository.save(ganreMusic);
    }

    @Override
    public List<GanreMusic> findAll() {
        return ganreMusicRepository.findAll();
    }

    @Override
    public GanreMusic findOne(int id) {
        return ganreMusicRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        ganreMusicRepository.delete(id);
    }
}
