package com.CargoManger.Goods.Service;

import com.CargoManger.Goods.Entity.Role;
import com.CargoManger.Goods.Entity.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    User updateUserRole(Long userId, Role newRole);

    List<User> getAllUsers();
}
