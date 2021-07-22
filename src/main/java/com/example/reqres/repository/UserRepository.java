package com.example.reqres.repository;

import com.example.reqres.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
