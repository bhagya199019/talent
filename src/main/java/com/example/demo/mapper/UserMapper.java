package com.example.demo.mapper;

import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.UserDto;
import com.example.demo.modal.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;


@Service
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
