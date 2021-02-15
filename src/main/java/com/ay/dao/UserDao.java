package com.ay.dao;

import com.ay.model.User;

public interface UserDao {
    User findByUsername(String username);
}
