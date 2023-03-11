package ua.jemm.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.jemm.springweb.model.User;
import ua.jemm.springweb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

//    public Optional<User> getOptionalById(Integer id) {
//        return userRepository.findById(id);
//    }

    public List<User> getByAgeAneName(Integer age, String name) {
        return userRepository.getUsersByAgeAndName(age, name);
//        return userRepository.getByAgeAneName(age,name);
    }

    public List<User> getByName(String name) {

        return null;
//return userRepository.findBy(name);
    }

    public List<User> getByAge(Integer age) {
        return userRepository.getUsersByAge(age);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
//
//    public User post(User user) {
//        return userRepository.post(user);
//    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Integer delete(Integer id) {
        userRepository.deleteById(id);
        return id;
    }
}
