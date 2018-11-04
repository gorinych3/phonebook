package ru.egor.DAO;

import ru.egor.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserImplDao implements DAO {

    private static UserImplDao INSTANCE = new UserImplDao();

    private List<User> model;

    public static UserImplDao getINSTANCE() {
        return INSTANCE;
    }

    private UserImplDao() {
        model = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        model.add(user);
    }

    @Override
    public List<String> list() {
        return model.stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }

    @Override
    public void update(User user) {
        int id = user.getId();
        model.removeIf(nextUser -> nextUser.getId() == id);
        model.add(user);
    }

    @Override
    public void delete(int id) {
        model.removeIf(nextUser -> nextUser.getId() == id);
    }
}
