package ua.editor;

import org.apache.poi.ss.formula.functions.Count;
import ua.entity.City;

import ua.entity.Country;
import ua.service.CityService;
import ua.service.CountryService;

import java.beans.PropertyEditorSupport;

public class CountryEditor extends PropertyEditorSupport { //

    private  final CountryService countryService;


    public CountryEditor(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Country country = countryService.findOne(Integer.parseInt(text));
        setValue(country);
//        super.setAsText(text);
    }
}

