package com.authen.jwt.service;

import com.authen.jwt.exception.ApplicationException;
import com.authen.jwt.repository.UserRepository;
import com.authen.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> showUserList() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Integer id) throws ApplicationException {
        Optional<User> result = userRepository.findById(id);
        if (!result.isPresent()) {
            throw new ApplicationException("Could not find any users with ID " + id);
        }
        return result.get();
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> result = userRepository.findById(id);
        if (!result.isPresent()) {
            throw new ApplicationException("Could not find any users with ID " + id);
        }
        userRepository.deleteById(id);

    }

}
