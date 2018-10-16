package com.cours.dao;

import java.util.List;

import com.cours.entities.User;

public interface IUser {
    public User connection(String email, String password);
    public int add(User user);
    public List<User> liste();
}
