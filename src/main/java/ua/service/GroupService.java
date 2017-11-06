package ua.service;

import ua.entity.Group;

import java.util.List;

public interface GroupService {

    void save(Group group);

    List<Group> findAll();

    Group findOne(int id);

    void delete(int id);
}
