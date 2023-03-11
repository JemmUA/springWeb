package ua.jemm.springweb.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.jemm.springweb.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUsersByAgeAndName(Integer age, String name);
    List<User> getUsersByAge(Integer age);


//    @Transactional
//    @Modifying
//    @Query("update User u set u.name = ?2  ")

//    @Transactional
//    @Modifying
//    @Query("insert into User u set u. = 1  ")
//    User post(User user);
}
