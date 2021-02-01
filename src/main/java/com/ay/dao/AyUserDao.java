package com.ay.dao;

import com.ay.model.AyUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AyUserDao {
    List<AyUser> findAll();

    int insert(AyUser ayUser);

    int delete(int id);

    int update(AyUser ayUser);

    int countByName(String name);

    AyUser findById(Integer id);

    List<AyUser> findByName(String name);

    AyUser findById2(Integer id);

    List<AyUser> findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    List<AyUser> findByNameAndPassword2(@Param("name") String name, @Param("password") String password);

    List<AyUser> findByNameAndPassword3(@Param("name") String name, @Param("password") String password);

    List<AyUser> findByNameAndPassword4(@Param("name") String name, @Param("password") String password);

    List<AyUser> findByIds(int[] ids);

    AyUser findById3(Integer id);

    int count();

    List<AyUser> find(@Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);
}