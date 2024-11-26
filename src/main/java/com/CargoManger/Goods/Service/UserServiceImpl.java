package com.CargoManger.Goods.Service;

import com.CargoManger.Goods.Entity.User;
import com.CargoManger.Goods.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email is already in use.");

        }

        //password encryption
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}
