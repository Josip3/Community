package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Integer>{

}
