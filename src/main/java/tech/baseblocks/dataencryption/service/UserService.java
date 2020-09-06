package tech.baseblocks.dataencryption.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.baseblocks.dataencryption.dto.UserDto;
import tech.baseblocks.dataencryption.mapper.UserMapper;
import tech.baseblocks.dataencryption.model.User;
import tech.baseblocks.dataencryption.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDto getUser(String userToken) {
        Optional<User> user = userRepository.findByToken(userToken);
        return userMapper.toDto(user.get());
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setToken(RandomStringUtils.randomAlphanumeric(6));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDto updateUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByToken(userDto.getToken());
        User user = userOptional.get();
        userMapper.updateEntity(user, userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
