package com.invest.investment.user.controller;

import com.invest.investment.user.entity.UserEntity;
import com.invest.investment.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserEntity findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.create(userEntity);
    }

    @PutMapping("/users/{id}")
    public UserEntity edit(@PathVariable("id") Long id, @RequestBody UserEntity userEntity){
        return userService.edit(userEntity);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

}
