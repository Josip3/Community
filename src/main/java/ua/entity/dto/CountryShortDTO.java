package ua.entity.dto;

public class CountryShortDTO {
    protected int id;

    protected String nameCountry;

    public int getId() {
        return id;
    }

    public CountryShortDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public CountryShortDTO setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
        return this;
    }

    @Override
    public String toString() {
        return "CountryShortDTO{" +
                "id=" + id +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
