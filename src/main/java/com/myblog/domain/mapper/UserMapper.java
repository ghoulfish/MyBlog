package com.myblog.domain.mapper;

import com.myblog.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

  @Insert("insert into users(username, password, role) values (#{username}, #{password}, #{role})")
  void insert(User user);

  @Update("update users set username=#{username}, password=#{password} where id=#{id}")
  int update(User user);

  @Delete("delete from users where id=#{id}")
  int delete(@Param("id") int id);

  @Select("select * from users")
  List<User> selectAll();

  @Select("select * from users where username=#{username}")
  User selectByName(@Param("username") String username);

  @Select("select * from users where id=#{id}")
  User selectById(@Param("id") int id);

  @Select("select role from users where id=#{id}")
  String getRoleById(@Param("id") int id);
}
