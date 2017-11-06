package ua.service;

import ua.entity.Country;

import java.util.List;

public interface CountryService {

    void save(Country country);

    List<Country> findAll();

    Country findOne(int id);

    void delete(int id);
}
