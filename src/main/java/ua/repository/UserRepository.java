package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.entity.Music;
import ua.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByName(String name);

    User findByEmail(String email);

    @Query("select u.musicList from User u where u.id = :id")
    List<Music> findAllMusic(@Param("id")Integer id);

}
