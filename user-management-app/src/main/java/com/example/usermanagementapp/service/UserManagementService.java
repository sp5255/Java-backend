package com.example.usermanagementapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.usermanagementapp.model.User;

@Service
public class UserManagementService {
    static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, 38383, "abc", "abc@user", "address@abc"));
        users.add(new User(2, 4884, "raman", "raman@user", "address@raman"));
        users.add(new User(3, 4883, "ashish", "ashish@user", "address@ashish"));
        users.add(new User(4, 483737, "harbir", "harbir@user", "address@harbir"));
        users.add(new User(5, 4938938, "xyz", "xyz@user", "address@abc"));

    }

    public List<User> getAllUser() {
        return users;
    }

    public User getUser(int id) {
        for (User user : users) {
            if (user.getUserId() == id)
                return user;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    // it will get the field that is present in body 
    // and if field present in class but not in body , then it will
    // be null by default
    public void updateUser(int id, User user) {
        User foundUser = getUser(id);
        foundUser.setUserId(user.getUserId());
        foundUser.setAddress(user.getAddress());
        foundUser.setName(user.getName());
        foundUser.setPhone_number(user.getPhone_number());
        foundUser.setUserName(user.getUserName());
    }

    public void deleteUser(int id) {
        int idx = -1;
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserId() == id) {
                idx = i;
                break;
            }
        }

        if (idx > 0)
            users.remove(idx);
    }

}
