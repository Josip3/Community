package ua.entity.dto;

import ua.entity.Country;

public class CityShortDTO {
    protected int id;
    protected Country country;
    protected String nameCity;

    public int getId() {
        return id;
    }

    public CityShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public CityShortDTO setCountry(Country country) {
        this.country = country;
        return this;
    }

    public String getNameCity() {
        return nameCity;
    }

    public CityShortDTO setNameCity(String nameCity) {
        this.nameCity = nameCity;
        return this;
    }

    @Override
    public String toString() {
        return "CityShortDTO{" +
                "id=" + id +
                ", country=" + country +
                ", nameCity='" + nameCity + '\'' +
                '}';
    }
}
