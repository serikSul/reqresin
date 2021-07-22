package com.example.reqres.controller;

import com.example.reqres.model.User;
import com.example.reqres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value ={"/api/users"},produces = "application/json")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> listOfUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        Optional<User> userOptional= userRepository.findById(id);
        if (userOptional.isPresent()){
            return    new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public User postBook(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("id")int id){
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public User putUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PatchMapping(path = "/{id}",consumes = "application/json")
    public User patchBook(@PathVariable("id") int id,@RequestBody User user){
        User userUpdate=userRepository.findById(id).get();
        if (user.getEmail()!=null){
            userUpdate.setEmail(user.getEmail());
        }
        if (user.getFirst_name()!=null){
            userUpdate.setFirst_name(user.getFirst_name());
        }
        if (user.getLast_name()!=null){
            userUpdate.setLast_name(user.getLast_name());
        }
        if (user.getAvatar()!=null){
            userUpdate.setAvatar(user.getAvatar());
        }
        return userRepository.save(userUpdate);
    }

}
