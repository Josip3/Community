package ua.editor;

import ua.entity.City;

import ua.service.CityService;

import java.beans.PropertyEditorSupport;

public class CityEditor extends PropertyEditorSupport {

    private  final CityService cityService;


    public CityEditor(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        City city = cityService.findOne(Integer.parseInt(text));
        super.setAsText(text);
    }
}

