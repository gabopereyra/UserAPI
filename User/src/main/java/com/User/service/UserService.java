package com.User.service;

import com.User.entity.UserEntity;
import com.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ArrayList<UserEntity> getAll(){
        return (ArrayList<UserEntity>) userRepository.findAll();
        //Se castea a un tipo userEntity, para poder regresarlo en JSON
    }

    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
        //Regresa el usuario que guardó junto a su ID
    }
}
