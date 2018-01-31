package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
}
