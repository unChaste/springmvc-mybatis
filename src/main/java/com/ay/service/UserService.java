package com.ay.service;

import com.ay.model.User;

public interface UserService {
    User findByUsername(String username);
}
