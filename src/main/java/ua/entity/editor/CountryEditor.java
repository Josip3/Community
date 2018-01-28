package ua.entity.editor;

import ua.entity.Country;
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

