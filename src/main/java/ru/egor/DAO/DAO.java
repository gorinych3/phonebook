package ru.egor.DAO;

import ru.egor.model.User;

import java.util.List;

public interface DAO {

    void add(User user);

    List<?> list();

    void update(User user);

    void delete(int id);


}
