package tech.baseblocks.dataencryption.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.baseblocks.dataencryption.dto.UserDto;
import tech.baseblocks.dataencryption.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserV1Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserV1Controller.class);

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{userToken}")
    public UserDto getById(@PathVariable String userToken) {
        LOGGER.info("Going to retrieve user by token {}", userToken);
        UserDto user = userService.getUser(userToken);
        LOGGER.info("Successfully retrieved user by token: {}", userToken);
        return user;
    }

    @PostMapping
    public UserDto create(@RequestBody  UserDto userDto) {
        LOGGER.info("Going to create user.");
        UserDto createdUser = userService.createUser(userDto);
        LOGGER.info("Successfully created user with token {}", createdUser.getToken());
        return createdUser;
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        LOGGER.info("Going to update user with token {}", userDto.getToken());
        UserDto updatedUser = userService.updateUser(userDto);
        LOGGER.info("Successfully updated user with token {}", updatedUser.getToken());
        return updatedUser;
    }
}
