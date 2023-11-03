package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.controller.SpringSecurityConfig.passwordEncoder;
@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/userdata/new")
    public UserDto createUser(@RequestBody UserDto userDto) {
        System.out.println("uus kasutaja");
        //User user = UserMapper.USER_MAPPER.userDtoToUser(userDto);

        User user = new User();
        user.setUsernickname(userDto.userNickname());
        user.setUseremail(userDto.userEmail());
        user.setUserpassword(userDto.userPassword());

        //String generatedPW = new BCryptPasswordEncoder().encode(userDto.userPassword());
        //String generatedPW = BCrypt.hashpw(userDto.userPassword(), BCrypt.gensalt(12));
        //user.setUserPassword(generatedPW);
        user.setUserpassword(passwordEncoder().encode(userDto.userPassword()));
        User saveNewUser = userRepository.save(user);
        return UserMapper.USER_MAPPER.userToUserDto(saveNewUser);
    }
}
