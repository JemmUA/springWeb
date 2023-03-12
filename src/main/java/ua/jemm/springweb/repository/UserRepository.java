package ua.jemm.springweb.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ua.jemm.springweb.controller.dto.IntegerDto;
import ua.jemm.springweb.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> getUsersByAgeAndName(Integer age, String name);
    List<User> getUsersByAge(Integer age);
    List<User> getUsersByName(String name);



//    @Transactional
//    @Modifying
//    @Query("update User u set u.name = ?2  ")

    @Transactional
    @Modifying
//    @Query(value = "insert into users (name, age) values(:name, :age), nativeQuery = true)
    @Query(
            value =
//                    "insert into users (id, name, age) values (:id, :name, :age)",
                    "insert into users (id, name, age) values (?1, ?2, ?3)",
            nativeQuery = true)
    Integer post(Integer id, String name, Integer age);
}
