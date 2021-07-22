package com.example.reqres.controller;

import com.example.reqres.model.Resource;
import com.example.reqres.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value ={"/api/unknown"},produces = "application/json")
public class UnknownRestController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping
    public Iterable<Resource> listOfResource(){
        return resourceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable("id") int id){
        Optional<Resource> resourceOptional= resourceRepository.findById(id);
        if (resourceOptional.isPresent()){
            return    new ResponseEntity<>(resourceOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
