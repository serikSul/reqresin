package com.example.reqres.repository;

import com.example.reqres.models.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource,Integer> {
}
