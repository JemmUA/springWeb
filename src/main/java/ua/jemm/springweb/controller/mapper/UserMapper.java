package ua.jemm.springweb.controller.mapper;

import org.springframework.stereotype.Component;
import ua.jemm.springweb.controller.dto.UserDto;
import ua.jemm.springweb.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toDto(User user) {

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getAge()
        );
    }
    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getAge()
        );
    }

    public List<UserDto> toDtoList(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<User> toEtntityList(List<UserDto> usersDto) {
        return usersDto.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
