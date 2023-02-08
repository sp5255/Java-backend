package com.example.usermanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usermanagementapp.model.User;
import com.example.usermanagementapp.service.UserManagementService;

@RestController
@RequestMapping("/api/v1/user")
public class UserManagementController {
    
     @Autowired
     UserManagementService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/id/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/id/{id}")  // PUT  updates/replaces the entire resource if it exists or creates new if it does not exist.
    public void updateUserInfo(@PathVariable int id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
