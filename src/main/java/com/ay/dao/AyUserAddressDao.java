package com.ay.dao;

import com.ay.model.AyUserAddress;

import java.util.List;

public interface AyUserAddressDao {
    AyUserAddress findById(Integer id);

    List<AyUserAddress> findByUserId(Integer userId);
}
