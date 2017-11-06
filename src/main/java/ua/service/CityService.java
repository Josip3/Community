package ua.service;

import ua.entity.City;

import java.util.List;

public interface CityService {

    void save(City city);

    List findAll();

    City findOne(int id);

    void delete(int id);


}
