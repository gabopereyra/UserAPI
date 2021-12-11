package com.User.controller;

import com.User.entity.UserEntity;
import com.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
        return this.userService.saveUser(userEntity);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @GetMapping("/query")
        public ArrayList<UserEntity> getUserByPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.userService.getByPrioridad(prioridad);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean status = this.userService.deleteUser(id);
        if(status){
            return "Se eliminó el usuario con el ID: "+id;
        } else{
            return "No se pudo eliminar el usuario con el ID: "+id;
        }
    }

}
