package com.authen.jwt.service;

import com.authen.jwt.exception.ApplicationException;
import com.authen.jwt.entity.User;

import java.util.List;

public interface UserService {
    List<User> showUserList();

    void saveUser(User user);

    User findById(Integer id) throws ApplicationException;

    void deleteUser(Integer id);

}
