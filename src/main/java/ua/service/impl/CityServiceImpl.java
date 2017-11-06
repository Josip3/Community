package ua.service.impl;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.City;
import ua.repository.CityRepository;
import ua.service.CityService;

import java.util.List;

@ToString
@Service
public class CityServiceImpl implements CityService {


    @Autowired
    private CityRepository citysRepository;


    @Override
    public void save(City city) {
        citysRepository.save(city);
    }

    @Override
    public List findAll() {
        return citysRepository.findAll();
    }

    @Override
    public City findOne(int id) {
        return citysRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        citysRepository.delete(id);
    }




}
