package com.alkemyjavachallange.java_challange.data;

import com.alkemyjavachallange.java_challange.model.User;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer> {
    User findByRole(String role);
}
