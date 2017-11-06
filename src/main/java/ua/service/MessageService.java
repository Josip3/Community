package ua.service;

import ua.entity.Message;

import java.util.List;

public interface MessageService {

    void save(Message message);

    List<Message> findAll();

    Message findOne(int id);

    void delete(int id);
}
