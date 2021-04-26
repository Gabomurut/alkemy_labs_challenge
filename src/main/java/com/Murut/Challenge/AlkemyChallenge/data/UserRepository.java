package com.Murut.Challenge.AlkemyChallenge.data;

import com.Murut.Challenge.AlkemyChallenge.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByRole(String role);
}
