package com.User.repository;

import com.User.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    public abstract ArrayList<UserEntity> findByPrioridad(Integer prioridad);
}
