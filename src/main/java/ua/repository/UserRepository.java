package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByName(String name);

    User findByEmail(String email);

}
