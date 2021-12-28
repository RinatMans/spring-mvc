package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersDAO {
    private static int USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Rinat", 36));
        users.add(new User(++USER_COUNT, "Love", 35));
        users.add(new User(++USER_COUNT, "Adelina", 11));
        users.add(new User(++USER_COUNT, "Liliana", 9));
        users.add(new User(++USER_COUNT, "Archi", 6));

    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }
}
