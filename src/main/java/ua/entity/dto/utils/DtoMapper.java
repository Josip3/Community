package ua.entity.dto.utils;

public interface DtoMapper {
    Object parseFromDTOtoObject(Object dtoObject, Class... parsingClasses);
}