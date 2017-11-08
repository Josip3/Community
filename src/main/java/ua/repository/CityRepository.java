package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {

}
