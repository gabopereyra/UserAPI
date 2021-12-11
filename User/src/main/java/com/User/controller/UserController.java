package com.User.controller;

import com.User.entity.UserEntity;
import com.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ArrayList<UserEntity> obtenerUsuarios(){
        return userService.getAll();
    }

    @PostMapping()
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return userService.saveUser(userEntity);
    }
}
