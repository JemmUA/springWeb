package ua.jemm.springweb.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.jemm.springweb.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FakeUserRepository {
    private List<User> users = new ArrayList<>();

    @PostConstruct
    public List<User> initUsers() {
        users.add(new User(0, "Adam", 1));
        users.add(new User(1, "Vasa", 33));
        users.add(new User(2, "Lida", 21));
        users.add(new User(3, "Bob", 36));
        users.add(new User(4, "Gena", 32));
        users.add(new User(5, "Rod", 11));
        users.add(new User(6, "Hellen", 11));
        users.add(new User(7, "Den", 11));
        users.add(new User(8, "Vasa", 11));
        return users;
    }

    public List<User> getAll() {

        return users;
    }

    public User getById(Integer id) {
        return users.get(id);
    }

    //    public User getByNameAndAge(Integer age, String name) {
//        return users.stream()
//                .filter(u -> u.getAge() == age && u.getName().equals(name))
//                .findAny()
//                .orElse(null);
//
//    }
    public List<User> getByAgeAneName(Integer age, String name) {
        return users.stream()
                .filter(u -> u.getAge() == age && u.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<User> getByName(String name) {
        return users
                .stream()
                .filter(u -> u.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<User> getByAge(Integer age) {
        return users.stream()
                .filter(u -> u.getAge() == age)
                .collect(Collectors.toList());
    }

    public User save(User user) {
        users.add(user);
        System.out.println(users);
        return user;
    }

    public User update(Integer id, User user) {
        User oldUser=users.get(id);
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        return users.get(id);
    }

    public Integer delete(Integer id) {
        users.remove((int)id); // need int instead Integer
        return id;
    }
}
