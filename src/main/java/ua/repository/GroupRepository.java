package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.Group;

public interface GroupRepository extends JpaRepository<Group,Integer> {

}
