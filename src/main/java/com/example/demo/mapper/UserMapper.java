package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public User selectUserById(int id);

    @Select("select * from user" )
    public List<User> findAll();

    @Insert("insert into user(name,age,address) values (#{name},#{age},#{address})")
    public void addUser(User user);

    @Update("update user set name=#{name},age=#{age},address=#{address} where id=#{id}")
    public void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public void deleteUser(int id);

}
