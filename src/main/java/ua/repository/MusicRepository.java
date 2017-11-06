package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Music;

public interface MusicRepository extends JpaRepository<Music,Integer> {

}
