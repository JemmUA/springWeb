package ua.jemm.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.jemm.springweb.controller.dto.IntegerDto;
import ua.jemm.springweb.controller.dto.StringDto;
import ua.jemm.springweb.controller.dto.UserDto;
import ua.jemm.springweb.controller.mapper.UserMapper;
import ua.jemm.springweb.model.User;
import ua.jemm.springweb.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    //    @RequestMapping(path = "/all", method = RequestMethod.GET )

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
//        return ResponseEntity.ok(userMapper.toDtoList(userService.getAll()));
        return new ResponseEntity<>(
                userMapper.toDtoList(userService.getAll()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
//        return null;
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.getById(id)),
                HttpStatus.OK);
    }

    @GetMapping("/{age}/{name}")
    public ResponseEntity<List<UserDto>> getByAgeAneName(@PathVariable Integer age,
                                                         @PathVariable String name) {
        System.out.println(name);
        System.out.println(age);
        return new ResponseEntity<>(
                userMapper.toDtoList(
                        userService.getByAgeAneName(age, name)),
                HttpStatus.OK);
    }

    @GetMapping("//")
    public ResponseEntity<List<UserDto>> getByAge(@RequestParam Integer age) {
        return new ResponseEntity<>(
                userMapper.toDtoList(
                        userService.getByAge(age)),
                HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        if (userDto == null || userDto.getName().isBlank()) {
            return ResponseEntity.badRequest().body(null);
        }
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.save(
                                userMapper.toEntity(userDto))),
                HttpStatus.CREATED);
    }

    @PostMapping("/post")
    public IntegerDto post(@RequestParam (required = true)  Integer id,
                           @RequestParam String name,
                           @RequestParam Integer age ){
        System.out.printf(String.format("post: id: %d, name: %s, age: %d\n",id, name , age));
        IntegerDto response = new IntegerDto(userService.post(id, name, age));
        System.out.println(response);
        return response;
    }

    @PutMapping()
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                userMapper.toDto(
                        userService.update(userMapper.toEntity(userDto))),
                HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(@RequestParam Integer id) {
        return new ResponseEntity<>(
                userService.delete(id),
                HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/email/{userId}")
    public StringDto getEmailById(@PathVariable Integer userId) {
        return new StringDto("mail@mail.ua", "Доброго ранку!");

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDto>> getByName(@PathVariable String name) {
        return new ResponseEntity<>(
                userMapper.toDtoList(userService.getByName(name)),
                HttpStatus.FOUND);
    }
}
