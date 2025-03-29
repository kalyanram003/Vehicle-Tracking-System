package com.kalyan.vehicle_tracking_system.service;


import java.util.List;
import java.util.Optional;

import com.kalyan.vehicle_tracking_system.model.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByPhone(String phone);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
