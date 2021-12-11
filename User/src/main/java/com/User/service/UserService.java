package com.User.service;

import com.User.entity.UserEntity;
import com.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<UserEntity> getById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserEntity> getByPrioridad(Integer prioridad){
        return userRepository.findByPrioridad(prioridad);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){

            return false;
        }
    }
}
